package com.totalcross.sample.dashboard.view.components;

public class AnimationFunctions {

    public AnimationFunctions() {
    }

    public double easeInSine(double t) {
        return Math.sin(1.5707963 * t);
    }

    public double easeOutSine(double t) {
        return 1 + Math.sin(1.5707963 * (--t));
    }

    public double easeInOutSine(double t) {
        return 0.5 * (1 + Math.sin(3.1415926 * (t - 0.5)));
    }

    public double easeInQuad(double t) {
        return t * t;
    }

    public double easeOutQuad(double t) {
        return t * (2 - t);
    }

    public double easeInOutQuad(double t) {
        return t < 0.5 ? 2 * t * t : t * (4 - 2 * t) - 1;
    }

    public double easeInCubic(double t) {
        return t * t * t;
    }

    public double easeOutCubic(double t) {
        return 1 + (--t) * t * t;
    }

    public double easeInOutCubic(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 + (--t) * (2 * (--t)) * (2 * t);
    }

    public double easeInQuart(double t) {
        t *= t;
        return t * t;
    }

    public double easeOutQuart(double t) {
        t = (--t) * t;
        return 1 - t * t;
    }

    public double easeInOutQuart(double t) {
        if (t < 0.5) {
            t *= t;
            return 8 * t * t;
        } else {
            t = (--t) * t;
            return 1 - 8 * t * t;
        }
    }

    public double easeInQuint(double t) {
        double t2 = t * t;
        return t * t2 * t2;
    }

    public double easeOutQuint(double t) {
        double t2 = (--t) * t;
        return 1 + t * t2 * t2;
    }

    public double easeInOutQuint(double t) {
        double t2;
        if (t < 0.5) {
            t2 = t * t;
            return 16 * t * t2 * t2;
        } else {
            t2 = (--t) * t;
            return 1 + 16 * t * t2 * t2;
        }
    }

    public double easeInExpo(double t) {
        return (Math.pow(2, 8 * t) - 1) / 255.0;
    }

    public double easeOutExpo(double t) {
        return 1 - Math.pow(2, -8 * t);
    }

    public double easeInOutExpo(double t) {
        if (t < 0.5) {
            return (Math.pow(2, 16 * t) - 1) / 510.0;
        } else {
            return 1 - 0.5 * Math.pow(2, -16 * (t - 0.5));
        }
    }

    double easeInCirc(double t) {
        return 1 - Math.sqrt(1 - t);
    }

    double easeOutCirc(double t) {
        return Math.sqrt(t);
    }

    double easeInOutCirc(double t) {
        if (t < 0.5) {
            return (1 - Math.sqrt(1 - 2 * t)) * 0.5;
        } else {
            return (1 + Math.sqrt(2 * t - 1)) * 0.5;
        }
    }

    double easeInBack(double t) {
        return t * t * (2.70158 * t - 1.70158);
    }

    double easeOutBack(double t) {
        return 1 + (--t) * t * (2.70158 * t + 1.70158);
    }

    double easeInOutBack(double t) {
        if (t < 0.5) {
            return t * t * (7 * t - 2.5) * 2;
        } else {
            return 1 + (--t) * t * 2 * (7 * t + 2.5);
        }
    }

    double easeInElastic(double t) {
        double t2 = t * t;
        return t2 * t2 * Math.sin(t * Math.PI * 4.5);
    }

    double easeOutElastic(double t) {
        double t2 = (t - 1) * (t - 1);
        return 1 - t2 * t2 * Math.cos(t * Math.PI * 4.5);
    }

    double easeInOutElastic(double t) {
        double t2;
        if (t < 0.45) {
            t2 = t * t;
            return 8 * t2 * t2 * Math.sin(t * Math.PI * 9);
        } else if (t < 0.55) {
            return 0.5 + 0.75 * Math.sin(t * Math.PI * 4);
        } else {
            t2 = (t - 1) * (t - 1);
            return 1 - 8 * t2 * t2 * Math.sin(t * Math.PI * 9);
        }
    }

    double easeInBounce(double t) {
        return Math.pow(2, 6 * (t - 1)) * Math.abs(Math.sin(t * Math.PI * 3.5));
    }

    double easeOutBounce(double t) {
        return 1 - Math.pow(2, -6 * t) * Math.abs(Math.cos(t * Math.PI * 3.5));
    }

    double easeInOutBounce(double t) {
        if (t < 0.5) {
            return 8 * Math.pow(2, 8 * (t - 1)) * Math.abs(Math.sin(t * Math.PI * 7));
        } else {
            return 1 - 8 * Math.pow(2, -8 * t) * Math.abs(Math.sin(t * Math.PI * 7));
        }
    }

}
