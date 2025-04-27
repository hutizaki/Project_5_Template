import java.awt.*;import java.awt.event.*;import java.io.*;import java.net.URL;import java.util.*;import javax.swing.*;import javax.swing.plaf.basic.*;import org.openstreetmap.gui.jmapviewer.*;import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;import org.openstreetmap.gui.jmapviewer.tilesources.*;import org.pushingpixels.radiance.animation.api.Timeline;import org.pushingpixels.radiance.animation.api.callback.TimelineCallbackAdapter;import com.hutizaki.ui.*;public class Working_Example{private double[]a={35.225147375380224,-97.44119495203651};private ArrayList<TripPoint>b,c,d;private Coordinate[]e;private MapPolygonImpl[]f;private int g=1;private MapMarker h,i;private Timeline j;private long k;private int[]l={0};private Icon m,n,o,p,q,r;private IconMarker u;private int v=15;private boolean w=false;private JFrame x;private JPanel y,z;private JLabel A;private JMapViewer B;private JButton C,D;private JCheckBox E0;private StyledComboBox<String>F0;private Font M0=new Font("San Francisco",Font.BOLD,25);private Color N0=new Color(52,25,13),O0=new Color(255,255,235);public Working_Example()throws IOException{System.out.println("Launching GUI...");Dimension p0=Toolkit.getDefaultToolkit().getScreenSize();processData("triplog.csv",g);x=new JFrame("Project 5 - Bryan Ho");x.setSize(p0.width,p0.height);x.setLayout(new BorderLayout());x.add(panel1(),BorderLayout.NORTH);x.add(panel2(),BorderLayout.CENTER);init3();x.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);x.setVisible(true);}private void processData(String p1,int p2)throws IOException{TripPoint.readFile(p1);if(p2==1)TripPoint.h1StopDetection();else TripPoint.h2StopDetection();b=TripPoint.getTrip();c=TripPoint.getMovingTrip();}private JPanel panel1()throws IOException{y=new JPanel(new BorderLayout());y.setBackground(N0);y.setPreferredSize(new Dimension(x.getContentPane().getWidth(),80));JLabel t1=new JLabel(icon4("title_icon.png",200,65));t1.setFont(M0);t1.setForeground(O0);JPanel t2=new JPanel(new FlowLayout(FlowLayout.LEFT,6,7));t2.setOpaque(false);t2.add(t1);JPanel t3=new JPanel();t3.setLayout(new BoxLayout(t3,BoxLayout.X_AXIS));t3.setOpaque(false);A=new JLabel("Duration: 00.00 Seconds ");A.setFont(M0);A.setForeground(O0);t3.add(A);t3.add(Box.createHorizontalStrut(30));t3.add(box5());t3.add(Box.createHorizontalStrut(40));t3.add(toggle6(O0));t3.add(Box.createHorizontalStrut(40));t3.add(btn7());t3.add(Box.createHorizontalStrut(10));t3.add(btn8());t3.add(Box.createHorizontalStrut(7));JPanel t4=new JPanel(new FlowLayout(FlowLayout.RIGHT,0,8));t4.setOpaque(false);t4.add(t3);y.add(t2,BorderLayout.WEST);y.add(t4,BorderLayout.EAST);return y;}private JPanel panel2(){z=new JPanel(new BorderLayout());TileSourceInfo ts1=new TileSourceInfo("Carto Light","https://a.basemaps.cartocdn.com/light_all","carto-light");TMSTileSource ts2=new TMSTileSource(ts1);B=new JMapViewer();B.setTileSource(ts2);B.setScrollWrapEnabled(true);B.setDisplayPosition(new Coordinate(a[0],a[1]),10);Image im=((ImageIcon)icon4("raccoon.png",50,50)).getImage();u=new IconMarker(new Coordinate(a[0],a[1]),im);B.addMapMarker(u);view9();z.add(B,BorderLayout.CENTER);return z;}private void view9(){d=E0.isSelected()?b:c;double minLat=d.get(0).getLat(),maxLat=minLat,minLon=d.get(0).getLon(),maxLon=minLon;for(TripPoint tp:d){double la=tp.getLat(),lo=tp.getLon();minLat=Math.min(minLat,la);maxLat=Math.max(maxLat,la);minLon=Math.min(minLon,lo);maxLon=Math.max(maxLon,lo);}h=new MapMarkerCircle(new Coordinate(maxLat,maxLon),0);i=new MapMarkerCircle(new Coordinate(minLat,minLon),0);B.addMapMarker(h);B.addMapMarker(i);}private JCheckBox toggle6(Color c1){StyledSwitchToggle sw=new StyledSwitchToggle("Include Stops: ");sw.setKnobColor(O0);sw.setFont(M0);E0=sw;E0.setForeground(c1);return E0;}private JButton btn7()throws IOException{m=icon4("play_button.png",32,32);n=icon4("play_button_hover.png",32,32);o=icon4("pause_button.png",32,32);p=icon4("pause_button_hover.png",32,32);C=new JButton(m);C.setBorderPainted(true);C.setFocusPainted(false);Dimension d0=new Dimension(64,64);C.setMaximumSize(d0);C.setMinimumSize(d0);C.setPreferredSize(d0);return C;}private JButton btn8()throws IOException{q=icon4("reset_button.png",32,32);r=icon4("reset_button_hover.png",32,32);D=new JButton(q);D.setBorderPainted(true);D.setFocusPainted(false);Dimension d1=new Dimension(64,64);D.setMaximumSize(d1);D.setMinimumSize(d1);D.setPreferredSize(d1);return D;}private StyledComboBox<String>box5(){String[]s0={"Animation Time","15 Seconds","30 Seconds","60 Seconds","90 Seconds"};F0=new StyledComboBox<>(s0);F0.setMaximumSize(new Dimension(200,30));return F0;}@SuppressWarnings("unused")private void init3(){C.addActionListener(e->{if(F0.getSelectedIndex()==0)return;w=!w;C.setIcon(w?p:m);B.setDisplayToFitMapMarkers();if(w){if(j==null||j.getState()==Timeline.TimelineState.IDLE||j.getState()==Timeline.TimelineState.DONE){reset10(true);w=true;l0(F0.getSelectedIndex()-1);k=System.nanoTime();j.play();}else if(j.getState()==Timeline.TimelineState.SUSPENDED)j.resume();}else j.suspend();});C.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){C.setIcon(w?p:n);}public void mouseExited(MouseEvent e){C.setIcon(w?o:m);}});E0.addActionListener(e->d=E0.isSelected()?b:c);F0.addActionListener(e->do11());D.addActionListener(e->reset10(true));D.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){D.setIcon(r);}public void mouseExited(MouseEvent e){D.setIcon(q);}});}private void do11(){String s1=(String)F0.getSelectedItem();v=Integer.parseInt(s1.substring(0,2));B.setDisplayToFitMapMarkers();reset10(true);}private Icon icon4(String fp,int w0,int h0){URL u0=Working_Example.class.getResource(fp);if(u0==null)throw new IllegalArgumentException("Resource not found");ImageIcon ii=new ImageIcon(u0);Image im=ii.getImage().getScaledInstance(w0,h0,Image.SCALE_SMOOTH);return new ImageIcon(im);}private void l0(int s0){m0(s0);n0();E0.setEnabled(false);l[0]=0;j=Timeline.builder(this).setDuration(v*1000L).addCallback(new TimelineCallbackAdapter(){public void onTimelinePulse(float df,float tp){int ix=Math.min((int)(tp*(e.length-1)),e.length-1);if(ix<l[0])return;while(l[0]<=ix){u.setLat(e[l[0]].getLat());u.setLon(e[l[0]].getLon());if(l[0]>0)f[l[0]-1].setVisible(true);l[0]++;}B.repaint();A.setText(String.format("Duration: %.2f Seconds",(System.nanoTime()-k)/1e9));}public void onTimelineStateChanged(Timeline.TimelineState os,Timeline.TimelineState ns,float df,float tp){if(ns==Timeline.TimelineState.DONE){w=false;reset10(false);}}}).build();}private void m0(int s0){e=new Coordinate[d.size()==0?0:(d.size()-1)*(s0+1)+1];int ix=0;TripPoint p0=d.get(0);e[ix++]=new Coordinate(p0.getLat(),p0.getLon());for(int j0=1;j0<d.size();j0++){TripPoint tp=d.get(j0);double la=tp.getLat(),lo=tp.getLon();for(int k0=1;k0<=s0;k0++){double fr=k0/(double)(s0+1);e[ix++]=new Coordinate(p0.getLat()+fr*(la-p0.getLat()),p0.getLon()+fr*(lo-p0.getLon()));}e[ix++]=new Coordinate(la,lo);p0=tp;}}private void n0(){f=new MapPolygonImpl[e.length-1];for(int i0=1;i0<e.length;i0++){MapPolygonImpl seg=new MapPolygonImpl(e[i0-1],e[i0],e[i0-1]);seg.setVisible(false);f[i0-1]=seg;B.addMapPolygon(seg);} }private void reset10(boolean clr){if(j!=null)j.abort();l[0]=0;C.setIcon(m);e=null;E0.setEnabled(true);if(clr){w=false;B.removeAllMapPolygons();u.setLat(a[0]);u.setLon(a[1]);B.repaint();A.setText("Duration: 00.00 Seconds");System.gc();}}public static void main(String[] args){UIManager.put("PanelUI",BasicPanelUI.class.getName());UIManager.put("LabelUI",BasicLabelUI.class.getName());SwingUtilities.invokeLater(()->{try{UIInitializer.ensureSkin();new Working_Example();}catch(Exception ex){ex.printStackTrace();}});} }
/**
 * Initializes and starts a frame-based animation for moving a map marker along a precomputed path.
 *
 * You must generate the frames using dataPoints (aka list that has TripPoints)
 * and use that as the frame counter vs relying on delay.
 *
 * @param dataPoints      array of Coordinates representing each frame position
 * @param animationSeconds total duration of the animation in seconds

private void setupFrameAnimation(Coordinate[] dataPoints, int animationSeconds) {
    // Record the start time in nanoseconds
    final long[] startTimeNs = { System.nanoTime() };
    // Total animation duration converted to milliseconds
    final long animationDurationMs = animationSeconds * 1_000L;
    // Number of frames to display
    final int frameCount = dataPoints.length;

    // Create a Swing timer to update the animation every 15ms
    Timer frameTimer = new Timer(15, null);
    frameTimer.setCoalesce(false);
    frameTimer.setInitialDelay(0);

    // Use an array so it can be mutated inside the listener
    final int[] currentFrameIndex = { 0 };

    frameTimer.addActionListener(evt -> {
        long now = System.nanoTime();
        long elapsedMs = (now - startTimeNs[0]) / 1_000_000L;

        // Determine which frame should be shown based on elapsed time
        int targetFrame = (int) ((elapsedMs / (double) animationDurationMs) * (frameCount - 1));
        targetFrame = Math.min(targetFrame, frameCount - 1);

        // Advance the frame index up to the target
        while (currentFrameIndex[0] <= targetFrame) {
            Coordinate next = dataPoints[currentFrameIndex[0]];
            marker.setLat(next.getLat());
            marker.setLon(next.getLon());
            if (currentFrameIndex[0] > 0) {
                pathSegments[currentFrameIndex[0] - 1].setVisible(true);
            }
            currentFrameIndex[0]++;
        }

        mapViewer.repaint();

        // Stop the timer and finalize when all frames shown
        if (currentFrameIndex[0] >= frameCount) {
            frameTimer.stop();
            double elapsedSec = (now - startTimeNs[0]) / 1e9;
            durationLabel.setText(String.format("Duration: %.2f Seconds", elapsedSec));
            restartAnimation(false);
        }
    });

    frameTimer.start();
}
*/