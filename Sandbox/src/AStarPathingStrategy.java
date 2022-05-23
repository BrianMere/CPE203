import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AStarPathingStrategy
        implements PathingStrategy
{


    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors)
    {
        List<Point> path = new LinkedList<Point>();

        Map<PathNode, Double> g_vals = new HashMap<>(); // And extension of openList to store G_vals
        // How to compare PathNodes
        Comparator<PathNode> comp = (p1,p2)->Double.compare((g_vals.get(p1) + getDistance(p1.getPoint(), end)), ((g_vals.get(p2) + getDistance(p2.getPoint(), end))));
        // F = G + H = g_val + H (heuristic, estimated distance)

        PriorityQueue<PathNode> openList = new PriorityQueue<>(comp);
        Map<Point, Boolean> closedList = new HashMap<>(); // Map a point to a specific boolean value. By default all values are false.

        // Start and end points represented as PathNodes
        PathNode firstPathNode = new PathNode(start, null); // Starting node has no prior nodes
        PathNode lastPathNode = new PathNode(end, null);

        PathNode currentNode = firstPathNode;
        openList.add(currentNode); // 1/2. Add start node to open list and mark as current node (G = 0, H = dist, F = dist)
        g_vals.put(currentNode, 0.0);

        while(!currentNode.equals(lastPathNode)){ // Continue to generate 'pointers' until you've hit the end point
            for(Point neighbor : potentialNeighbors.apply(currentNode.getPoint()).filter(canPassThrough).toList()){
                if(!closedList.containsKey(neighbor)){
                    PathNode potNewNode = new PathNode(neighbor, currentNode);
                    if(openList.contains(potNewNode)) {
                        if (g_vals.get(potNewNode) > g_vals.get(currentNode) + 1.0) {
                            g_vals.put(potNewNode, g_vals.get(currentNode) + 1.0);
                        }
                    }
                    else{
                        g_vals.put(potNewNode, g_vals.get(currentNode) + 1.0);
                    }
                    openList.add(potNewNode);
                }
            }
            closedList.put(currentNode.getPoint(), true);
            currentNode = openList.poll();
        }

        // At this point, we'll have a generated assortment of PathNodes that point to other PathNodes,
        // but our path will have the target's previous point reference another point and so on back to the beginning

        // Also, at this point because of the above while loop then currentNode.equals(lastPathNode), which is our target
        while(!currentNode.equals(firstPathNode)){
            path.add(0, currentNode.getPoint());
            currentNode = currentNode.getPriorNode();
        }

        return path;
    }

    // Helpers
    private double getDistance(Point p1, Point p2){ //Can change to become euclidean or manhattan, but then signature needs to change
        return Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
    }
}
