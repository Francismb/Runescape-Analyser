package org.rs.analysis.visual.view;

import org.rs.analysis.visual.controller.MainController;
import org.rs.analysis.visual.model.MainModel;

import javax.swing.*;
import java.awt.*;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public class MainView extends View<MainModel, MainController> {

    public JFrame frame;
    public JButton rs3Button;
    public JButton osrsButton;

    public MainView(final MainController controller) {
        super(controller);
    }

    @Override
    public void init() {
        frame = new JFrame("RS Client");

        final Container container = frame.getContentPane();
        final GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);

        rs3Button = new JButton("RS3");
        osrsButton = new JButton("OSRS");


        final GroupLayout.SequentialGroup horizontal = layout.createSequentialGroup();
        final GroupLayout.SequentialGroup vertical = layout.createSequentialGroup();

        horizontal.addGroup(layout.createParallelGroup()
                        .addComponent(rs3Button)
        );
        horizontal.addGroup(layout.createParallelGroup()
                        .addComponent(osrsButton)
        );

        vertical.addGroup(layout.createParallelGroup()
                        .addComponent(rs3Button)
                        .addComponent(osrsButton)
        );

        layout.setHorizontalGroup(horizontal);
        layout.setVerticalGroup(vertical);

        rs3Button.addActionListener(controller.rs3Action);
        osrsButton.addActionListener(controller.osrsAction);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocale(null);
        frame.pack();
    }

}
