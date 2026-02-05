package com.example.lcj.base.finaltest.finalArguments;

/**
 * @author lichengjian
 * @date 2023/12/24
 */
public class FinalArguments {
    void with(final Gizmo g) {
        // g = new Gizmo();
    }

    void without(Gizmo g) {
        g = new Gizmo();
        g.spin();
    }
}
