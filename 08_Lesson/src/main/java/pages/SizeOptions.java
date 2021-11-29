package pages;

public enum SizeOptions {
    S('S'),
    M('M'),
    L('L');

    public final char label;

    private SizeOptions(char label) {
        this.label = label;
    }
}
