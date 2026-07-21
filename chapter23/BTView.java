import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {

    private BST<Integer> tree;
    private double radius = 15;
    private double hGap = 70;   // distance between levels
    private double vGap = 60;   // distance between children

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        getChildren().clear();

        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), 40, getHeight() / 2, getHeight() / 4);
        }
    }

    /** Display a subtree horizontally */
    private void displayTree(BST.TreeNode<Integer> root,
                             double x, double y, double gap) {

        // Left child
        if (root.left != null) {
            getChildren().add(new Line(x, y,
                    x + hGap, y - gap));

            displayTree(root.left,
                    x + hGap,
                    y - gap,
                    gap / 2);
        }

        // Right child
        if (root.right != null) {
            getChildren().add(new Line(x, y,
                    x + hGap, y + gap));

            displayTree(root.right,
                    x + hGap,
                    y + gap,
                    gap / 2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}
