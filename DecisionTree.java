class DecisionTree {
    private DecisionTree left;
    private DecisionTree right;
    private String decision;

    public DecisionTree(DecisionTree left, DecisionTree right) {
        this.left = left;
        this.right = right;
    }

    public DecisionTree(String decision) {
        this.decision = decision;
    }

    public DecisionTree getLeft() {
        return left;
    }

    public DecisionTree getRight() {
        return right;
    }

    public void setVal(String decision) {
        this.decision = decision;
    }

    public void setLeft(DecisionTree d) {
        this.left = d;
    }

    public void setRight(DecisionTree d) {
        this.right = d;
    }
}