package music;

class NoteKey {
    private final boolean flag1;
    private final boolean flag2;
    private final boolean flag3;

    public NoteKey(boolean flag1, boolean flag2, boolean flag3) {
        this.flag1 = flag1;
        this.flag2 = flag2;
        this.flag3 = flag3;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NoteKey)) {
            return false;
        }

        NoteKey otherKey = (NoteKey) object;
        return this.flag1 == otherKey.flag1 && this.flag2 == otherKey.flag2 && this.flag3 == otherKey.flag3;
    }

    @Override
    public int hashCode() {
        int result = 17; // any prime number
        result = 31 * result + Boolean.valueOf(this.flag1).hashCode();
        result = 31 * result + Boolean.valueOf(this.flag2).hashCode();
        result = 31 * result + Boolean.valueOf(this.flag3).hashCode();
        return result;
    }
}