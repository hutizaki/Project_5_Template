

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

/**
 * Project 5 Template – fill in the TODOs below.
 */
public class Project5Template {
    // ─── Fields to hold your data and UI controls ───
    // TODO: declare a List<TripPoint> called allPoints
    // TODO: declare a List<TripPoint> called movingPoints
    // TODO: declare a List<TripPoint> called stopPoints
    // TODO: declare JComboBox<String> animationCombo
    // TODO: declare JCheckBox includeStopsCheckbox
    // TODO: declare JButton playButton
    // TODO: declare JMapViewer mapViewer

    public static void main(String[] args) {
        // 1) Read the triplog file and detect stops BEFORE showing UI
        //    Hint: use TripPoint.parse(...) or your CSV reader
        // TODO: List<TripPoint> allPoints = loadTripData("path/to/triplog.csv");
        // TODO: movingPoints = StopDetector.h1(allPoints)  OR  StopDetector.h2(allPoints);

        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void createAndShowGUI() {
        // 2) Create the main frame, include your name in the title:
        JFrame frame = new JFrame("Project 5 – Your Name Here");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);

        // 3) Build and add the top control panel:
        JPanel topPanel = createTopPanel();
        frame.add(topPanel, BorderLayout.NORTH);

        // 4) Build and add the map panel:
        JPanel mapPanel = createMapPanel();
        frame.add(mapPanel, BorderLayout.CENTER);

        // 5) After adding everything, attach your listeners:
        // TODO: addListeners();

        // 6) Show the window
        frame.setVisible(true);
    }

    private static JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(new Color(0, 120, 215));
        panel.setPreferredSize(new Dimension(Component.WIDTH, 80));

        // ── REQUIRED GUI CONTROLS ──

        // a) Animation speed selector (JComboBox with 15, 30, 60, 90)
        // TODO: animationCombo = new JComboBox<>(new String[]{"15","30","60","90"});
        // TODO: animationCombo.setSelectedItem("15");
        // TODO: panel.add(animationCombo);

        // b) Include stops checkbox (default unchecked)
        // TODO: includeStopsCheckbox = new JCheckBox("Include Stops");
        // TODO: includeStopsCheckbox.setSelected(false);
        // TODO: panel.add(includeStopsCheckbox);

        // c) Play/Reset button
        // TODO: playButton = new JButton("Play");
        // TODO: panel.add(playButton);

        return panel;
    }

    private static JPanel createMapPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 1) Instantiate JMapViewer
        JMapViewer map = new JMapViewer();
        // TODO: assign to field: mapViewer = map;

        // 2) Optional: set a custom tile source (if desired)
        // TODO: // map.setTileSource(...);

        // 3) Enable wrap-around
        map.setScrollWrapEnabled(true);

        // 4) Center on your trip’s area (e.g., OU campus)
        map.setDisplayPosition(new Coordinate(35.2233, -97.4419), 10);

        // 5) Optionally, add initial marker(s)
        // TODO: map.addMapMarker(new MapMarkerDot(35.2233, -97.4419));

        panel.add(map, BorderLayout.CENTER);
        return panel;
    }

    // ─── Listener wiring ───
    private static void addListeners() {
        // TODO: playButton.addActionListener(e -> {
        //     // 1) clear existing markers/lines from mapViewer
        //     // 2) choose data = includeStopsCheckbox.isSelected() ? allPoints : movingPoints
        //     // 3) int seconds = Integer.parseInt((String)animationCombo.getSelectedItem());
        //     // 4) animateTrip(data, seconds);
        // });
    }

    // ─── Animation stub ───
    private static void animateTrip(List<?> points, int durationSeconds) {
        // TODO: clear any previous overlays/markers
        // TODO: compute delay = durationSeconds * 1000 / points.size()
        // TODO: use a Swing Timer to:
        //      - move a “current position” marker (e.g., raccoon icon) along each point
        //      - draw a line from the previous point to the current
        //      - stop when all points have been shown
    }

    // ─── Data‐loading stub ───
    private static java.util.List<?> loadTripData(String filename) throws FileNotFoundException, IOException {
        // TODO: open filename, parse lines into TripPoint objects
        // TODO: return a List<TripPoint>
        return null;
    }
}
