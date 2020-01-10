import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Path("/message")
public class JSONservice {

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Hello world!!" + "\n\n\n" + "Restful example: " + msg;
        return Response.status(200).entity(result).build();
    }



   String getDrawing(String str) {

        int width = 100;
        int height = 3000;

        //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(str, 10, 20);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));
        String grandeFinale = "";
       StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }
        }

        return sb.toString();
    }

}