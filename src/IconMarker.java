import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

/**
 * @author wellsantos@wellsantos.com
 * @created 18/09/2014
 */
public class IconMarker extends MapMarkerCircle implements MapMarker {

    private Image image;

    public IconMarker(Coordinate coord, Image image) {
        this(coord, 1, image);
    }

    public IconMarker(Coordinate coord, double radius, Image image) {
        super(coord, radius);
        this.image = image;
    }

    @Override
    public void paint(Graphics g, Point position, int radio) {
        double r = this.getRadius();
        int width = (int) (this.image.getWidth(null) * r);
        int height = (int) (this.image.getHeight(null) * r);
        int w2 = width / 2;
        int h2 = height / 2;
        g.drawImage(this.image, position.x - w2, position.y - h2, width, height, null);
        this.paintText(g, position);
    }
    
    public void setCoord(Coordinate newCoord) {
    	this.setLat(newCoord.getLat());
    	this.setLon(newCoord.getLon());
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}