package leetcode.no478;

class Solution {

    public double radius;
    public double x_center;
    public double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x;
        double y;
        do {
            x = x_center + randomzhengfu() * radius * Math.random();
            y = y_center + randomzhengfu() * radius * Math.random();
        } while (Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2) > Math.pow(this.radius, 2));
        return new double[] {x, y};
    }

    public int randomzhengfu() {
        double res = 0;
        do {
            res = Math.random();
        } while ((new Double(res).equals(new Double(0.5))));
        return res > 0.5 ? 1 : -1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(1, 0, 0);
        double[] res= obj.randPoint();
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
