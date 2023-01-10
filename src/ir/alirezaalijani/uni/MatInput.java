package ir.alirezaalijani.uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alireza Alijani : <a href="https://alirezaalijani.ir">https://alirezaalijani.ir</a>
 * @email alirezaalijani.ir@gmail.com
 * @date 12/25/2022
 */
public class MatInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Nods (split by ','):");

        String nodesName = scanner.nextLine();

        List<Vertex> vertices = new ArrayList<>();
        for (String v : nodesName.split(",")) {
            vertices.add(new Vertex(v));
        }

        System.out.println("\n-------------- insert mat ---------------\n");
        System.out.print("   ");
        for (Vertex vertex : vertices) {
            System.out.print(vertex.getName() + " ");
        }
        System.out.println();


        List<String[]> mat = new ArrayList<>(vertices.size());

        for (Vertex node : vertices) {
            System.out.print(node.getName() + "  ");
            String line = scanner.nextLine();
            String[] row = line.split(" ");
            for (int i = 0; i < row.length; i++) {
                if (row[i].equals("1")) {
                    Vertex neighbor = vertices.get(i);
                    if (!neighbor.equals(node)) {
                        node.addNeighbour(neighbor);
                    }
                }
            }
            mat.add(row);
        }

        System.out.println();
        for (String[] row : mat) {
            System.out.print("  ");
            for (String index : row) {
                System.out.print(" " + index);
            }
            System.out.println();
        }
        System.out.println();

        CycleDfs.detectCycle(vertices);

    }
}
