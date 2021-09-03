package edu.nju.seg.model;

import com.microsoft.z3.BoolExpr;

import java.util.*;

public class Seq {

    private static int global_index = 0;

    private int index;

    private String label = "";

    private Map<Instance, List<Message>> seq = new HashMap<>();

    private final List<BoolExpr> properties = new ArrayList<>();

    private final List<BoolExpr> constraints = new ArrayList<>();

    public Seq(Map<Instance, List<Message>> seq)
    {
        this.seq = seq;
        index = global_index;
        global_index += 1;
    }

    public Seq(List<Instance> covered)
    {
        for (Instance i: covered) {
            seq.put(i, new ArrayList<>());
        }
        index = global_index;
        global_index += 1;
    }

    public Seq(String label, Map<Instance, List<Message>> seq)
    {
        this.label = label;
        this.seq = seq;
        index = global_index;
        global_index += 1;
    }

    public int get_index()
    {
        return index;
    }

    public List<BoolExpr> get_properties()
    {
        return properties;
    }

    public List<BoolExpr> get_constraints()
    {
        return constraints;
    }

    public void append_property(BoolExpr e)
    {
        properties.add(e);
    }

    public void append_constraint(BoolExpr e)
    {
        constraints.add(e);
    }

    public void set_label(String label) {
        this.label = label;
    }

    public String get_label()
    {
        return label;
    }

    public Map<Instance, List<Message>> get_seq()
    {
        return seq;
    }

    public static Seq clone(Seq s)
    {
        return new Seq(s.get_label(), s.get_seq());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seq seq1 = (Seq) o;
        return label.equals(seq1.label) &&
                seq.equals(seq1.seq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq);
    }

}
