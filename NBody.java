import Project0.*;

public class NBody {
    public static double universeRadius = 0;
    public static Body[] bodies;

    public static double readRadius(String FileName){
        In inFile = new In(FileName);
        return inFile.readDouble();
    }

    public static Body[] readBodies(String FileName){
        In inFile = new In(FileName);
        int N = inFile.readInt();
        universeRadius = inFile.readDouble();
        Body[] bodies = new Body[N];
        for (int i = 0; i < N; i++){
            double xP = inFile.readDouble();
            double yP = inFile.readDouble();
            double xV = inFile.readDouble();
            double yV = inFile.readDouble();
            double m = inFile.readDouble();
            String img = inFile.readString();
            bodies[i] = new Body(xP, yP, xV, yV, m, img);
        }
        return bodies;
    }
    public static void main(String[] args){
        /** Body[0]: Samh   Body[1]:Aegir   Body[2]:Rocinante */
        /** test codes are showing below
         * 
        Body[] bodies = new Body[3];
        bodies[0] = new Body(1,0,-1,1,10,"pic");
        bodies[1] = new Body(3,3,-2,1,5,"pic");
        bodies[2] = new Body(5,-3,2,3,50,"pic");
        // System.out.println(bodies[0].calcDistance(bodies[1]));
        // System.out.println(bodies[0].calcForceExertedBy(bodies[2]));
        // System.out.println(bodies[0].calcForceExertedByX(bodies[2]));
        // System.out.println(bodies[0].calcNetForceExertedByX(bodies));
        // System.out.println(bodies[0].calcNetForceExertedByY(bodies));
        double SamhForceX = bodies[0].calcNetForceExertedByX(bodies);
        double SamhForceY = bodies[0].calcNetForceExertedByY(bodies);
        double dt = 0.05;
        System.out.format("Samh's initial position is (%s,%s)\n", Double.toString(bodies[0].xxPos), Double.toString(bodies[0].yyPos));
        System.out.format("With net Force: (%s,%s) exerted in %f second.\n", Double.toString(SamhForceX), Double.toString(SamhForceY), dt);
        bodies[0].update(dt, SamhForceX, SamhForceY);
        System.out.format("Samh's final position is (%s,%s)", Double.toString(bodies[0].xxPos), Double.toString(bodies[0].yyPos));
        
        universeRadius = readRadius("radius.txt");
        System.out.println(universeRadius);
        bodies = readBodies("planet.txt");
        for (Body a: bodies){
            String planetName = a.imgFileName.substring(0, a.imgFileName.length() - 4);
            System.out.format("Planet %s: (%s,%s), mess is %s\n", 
            planetName, Double.toString(a.xxPos), Double.toString(a.yyPos), Double.toString(a.mess));
        }
        * 
        */

        /** Drawing the Universe. */
        /** Obtain the arges */
        if (args.length < 3){
            System.out.println("More args required!!!");
        }
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        /** Initialization */
        bodies = readBodies(filename);
        String Background = "images/starfield.jpg";
        double t = 0;
        int bodyNum = bodies.length;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-1 * universeRadius, universeRadius);
        StdDraw.clear();

        /** Calculating and Drawing */
        while (t < T){
            double[] xForce = new double[bodyNum];
            double[] yForce = new double[bodyNum];
            
            /** Calculate the Net Force */
            for (int j = 0; j < bodyNum; j++){
                double xxF = bodies[j].calcNetForceExertedByX(bodies);
                double yyF = bodies[j].calcNetForceExertedByY(bodies);
                xForce[j] = xxF;
                yForce[j] = yyF;
            }

            /** Update all bodies' position */
            for (int k = 0; k < bodyNum; k++){
                bodies[k].update(dt, xForce[k], yForce[k]);
            }

            /** Draw */
            StdDraw.picture(0, 0, Background);
            for (Body d:bodies){
                d.draw();
            }
            StdDraw.show();
		    StdDraw.pause(10);
            
            t = t + dt;
        }
    }
}
