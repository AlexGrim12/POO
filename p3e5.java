import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Scanner;

public class p3e5 {

    // Método para buscar un descendiente en el árbol (insensible a
    // mayúsculas/minúsculas)
    public static TreeNode buscarDescendiente(TreeNode root, String nombre) {
        if (root.toString().equalsIgnoreCase(nombre)) {
            return root;
        }
        for (int i = 0; i < root.getChildCount(); i++) {
            TreeNode resultado = buscarDescendiente(root.getChildAt(i), nombre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    // Método para imprimir el árbol genealógico
    public static void printTree(TreeNode root, String indent) {
        System.out.println(indent + root);
        for (int i = 0; i < root.getChildCount(); i++) {
            printTree(root.getChildAt(i), indent + " | ");
        }
    }

    public static void main(String[] args) {

        // Crear los nodos para los personajes
        DefaultMutableTreeNode uranos = new DefaultMutableTreeNode("Uranos");
        DefaultMutableTreeNode cronos = new DefaultMutableTreeNode("Cronos");

        DefaultMutableTreeNode zeus = new DefaultMutableTreeNode("Zeus");
        DefaultMutableTreeNode ades = new DefaultMutableTreeNode("Ades");
        DefaultMutableTreeNode hestia = new DefaultMutableTreeNode("Hestia");
        DefaultMutableTreeNode demeter = new DefaultMutableTreeNode("Deméter");
        DefaultMutableTreeNode hera = new DefaultMutableTreeNode("Hera");
        DefaultMutableTreeNode poseidon = new DefaultMutableTreeNode("Poseidón");

        DefaultMutableTreeNode hefesto = new DefaultMutableTreeNode("Hefesto");
        DefaultMutableTreeNode ares = new DefaultMutableTreeNode("Ares");
        DefaultMutableTreeNode dioniso = new DefaultMutableTreeNode("Dioniso");
        DefaultMutableTreeNode hermes = new DefaultMutableTreeNode("Hermes");
        DefaultMutableTreeNode atenea = new DefaultMutableTreeNode("Atenea");
        DefaultMutableTreeNode artemisa = new DefaultMutableTreeNode("Artemisa");
        DefaultMutableTreeNode apolo = new DefaultMutableTreeNode("Apolo");
        DefaultMutableTreeNode afrodita = new DefaultMutableTreeNode("Afrodita");

        // Construir el árbol genealógico
        uranos.add(cronos);

        cronos.add(zeus);
        cronos.add(poseidon);
        cronos.add(ades);
        cronos.add(hestia);
        cronos.add(demeter);
        cronos.add(hera);
        cronos.add(poseidon);

        zeus.add(hefesto);
        zeus.add(ares);
        zeus.add(dioniso);
        zeus.add(hermes);
        zeus.add(atenea);
        zeus.add(artemisa);
        zeus.add(apolo);
        zeus.add(afrodita);

        // Imprimir el árbol genealógico
        System.out.println("Arbol Genealógico Griego:");
        printTree(uranos, "");

        // Buscar un descendiente
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa el nombre que deseas buscar: ");
        String nombreABuscar = sc.nextLine();
        TreeNode nodoEncontrado = buscarDescendiente(uranos, nombreABuscar);
        if (nodoEncontrado != null) {
            System.out.println("Descendiente encontrado: " + nodoEncontrado);
            if (nodoEncontrado.getParent() != null)
                System.out.println("\nPadre: " + nodoEncontrado.getParent());
            else
                System.out.println("\nPadre: No tiene");
            // desendientes
            if (nodoEncontrado.getChildCount() == 0)
                System.out.println("\nHijos: No tiene");
            else {
                System.out.println("\nHijos: ");
                for (int i = 0; i < nodoEncontrado.getChildCount(); i++) {
                    System.out.println(" - " + nodoEncontrado.getChildAt(i));
                }
            }
        } else {
            System.out.println("Descendiente no encontrado: " + nombreABuscar);
        }

        // Agregar un descendiente a Zeus
        System.out.println("\nAgregar un descendiente a Zeus:");
        System.out.print("Ingresa el nombre del nuevo descendiente: ");
        String descendiente = sc.nextLine();
        DefaultMutableTreeNode nuevoDescendiente = new DefaultMutableTreeNode(descendiente);
        zeus.add(nuevoDescendiente);

        // Imprimir el árbol genealógico actualizado
        System.out.println("\nArbol Genealógico Actualizado:");
        printTree(uranos, "");

        // Eliminar un descendiente de Zeus
        System.out.println("\nEliminar un descendiente de Zeus:");
        System.out.print("Ingresa el nombre del descendiente a eliminar: ");
        descendiente = sc.nextLine();
        DefaultMutableTreeNode nodoAEliminar = (DefaultMutableTreeNode) buscarDescendiente(zeus, descendiente);
        if (nodoAEliminar != null) {
            zeus.remove(nodoAEliminar);
            System.out.println("Descendiente eliminado: " + nodoAEliminar);
        } else {
            System.out.println("Descendiente no encontrado: " + descendiente);
        }

        // Imprimir el árbol genealógico actualizado
        System.out.println("\nArbol Genealógico Actualizado:");
        printTree(uranos, "");

        sc.close();
    }
}
