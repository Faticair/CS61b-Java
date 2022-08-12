package Project0;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mess;
    public String imgFileName;

    public static final double Gpara = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mess = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mess = b.mess;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2));
    }

    public double calcForceExertedBy(Body b){
        double r = this.calcDistance(b);
        return Body.Gpara * this.mess * b.mess / Math.pow(r, 2);
    }

    public double calcForceExertedByX(Body b){
        double r = this.calcDistance(b);
        double Force = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        return Force * dx / r;
        
    }

    public double calcForceExertedByY(Body b){
        double r = this.calcDistance(b);
        double Force = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        return Force * dy / r;
        
    }

    public double calcNetForceExertedByX(Body[] allbodies){
        double netForceX = 0;
        for ( Body a: allbodies){
            if (a.equals(this)){
                continue;
            }
            netForceX = netForceX + this.calcForceExertedByX(a);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body[] allbodies){
        double netForceY = 0;
        for ( Body a: allbodies){
            if (a.equals(this)){
                continue;
            }
            netForceY = netForceY + this.calcForceExertedByY(a);
        }
        return netForceY;
    }

    public void update(double dt, double xF, double yF){
        double xA = xF / this.mess;
        double yA = yF / this.mess;
        this.xxVel = xxVel + dt * xA;
        this.yyVel = yyVel + dt * yA;
        /** Shift = V_old * dt + 0.5 * a * dt^2 approximately equals dt * V_new
         * P_new = P_old + Shift */
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}

