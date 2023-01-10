package ir.alirezaalijani.uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Alireza Alijani : <a href="https://alirezaalijani.ir">https://alirezaalijani.ir</a>
 * @email alirezaalijani.ir@gmail.com
 * @date 12/25/2022
 */
public class CycleDfs {

    public static void detectCycle(List<Vertex> vertexList) {

        for (Vertex vertex : vertexList) {
//            if( !vertex.isVisited() ){
            resetVertex(vertexList);
            List<Vertex> cycleList = dfsCycle(vertex);
            if (cycleList!=null){
                String cycles = cycleList.stream()
                        .map(Vertex::getName)
                        .collect(Collectors.joining("->", "{" + vertex.getName() + "->", "}"));
                System.out.printf("vertex %s has cycle : %s%n", vertex.getName(), cycles);
            }

//                dfs(vertex);
//            }

        }
    }

    public static void resetVertex(List<Vertex> vertexList) {
        vertexList
                .forEach(vertex -> {
                    vertex.setVisited(false);
                    vertex.setBeingVisited(false);
                });
    }

    public static List<Vertex> dfsCycle(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        List<Vertex> cycleWith = new ArrayList<>();
        stack.add(root);
        root.setBeingVisited(true);
        System.out.println("DFS on vertex " + root.getName());
        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            for (Vertex v : actualVertex.getNeighbourList()) {

                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                    System.out.println("Visit vertex:" + v.getName());
                    cycleWith.add(v);
                }
                if (v.getName().equals(root.getName())) {
                    System.out.println("Backward edge " + root.getName());
                    return cycleWith;
                }
            }
        }
        return null;
    }
}
