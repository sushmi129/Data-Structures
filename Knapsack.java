package exp3;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int object, m;
        System.out.println("Enter the total objects : ");
        object = sc.nextInt();
        int weight[] = new int[object];
        int profit[] = new int[object];
        for(int i = 0; i < object; i++) {
        	System.out.println("Enter the profit ");
        	profit[i] = sc.nextInt();
        	System.out.println("Enter the weight : ");
        	weight[i] = sc.nextInt();
        }
        System.out.println("Enter the kanpsack capacity : ");
        m = sc.nextInt();
        double p_w[] = new double[object];
        for(int i = 0; i < object; i++) {
        	p_w[i] = (double)profit[i] / (double)weight[i];
        }
        System.out.println("");
        System.out.println("............");
        System.out.println(".....Data..Set.....");
        System.out.println("............");
        System.out.println();
        System.out.print("Objects - ");
        for(int i = 1; i <= object; i++)
        	System.out.print(i + " ");
        System.out.println();
        System.out.print("Profit - ");
        for(int i = 0; i < object; i++)
        	System.out.print(profit[i] + " ");
        System.out.println();
        System.out.print("Weight - ");
        for(int i = 0; i < object; i++)
        	System.out.print(weight[i] + " ");
        System.out.println("");
        System.out.print("p/w - ");
        for(int i = 0; i < object; i++)
        	System.out.print(p_w[i] + " ");
        System.out.println();
        for(int i = 0; i < object - 1; i++) {
        	for(int j = i + 1; j < object; j++) {
        		if(p_w[i] < p_w[j]) {
        			double temp = p_w[i];
        			p_w[i] = p_w[j];
        			p_w[j] = temp;
        			int temp1 = profit[j];
        			profit[j] = profit[i];
        			profit[i] = temp1;
        			int temp2 = weight[i];
        			weight[i] = weight[j];
        			weight[j] = temp2;
        		}
        	}
        }
        System.out.println();
        System.out.println("..........");
        System.out.println(".....After Arranging.....");
        System.out.println("..........");
        System.out.print("Objects - ");
        for(int i = 1; i <= object; i++)
        	System.out.print(i + " ");
        System.out.println();
        System.out.print("Profit - ");
        for(int i = 0; i  < object; i++)
        	System.out.print(profit[i] + " ");
        System.out.println();
        System.out.print("Weights - ");
        for(int i = 0; i < object; i++)
        	System.out.print(weight[i] + " ");
        System.out.println();
        System.out.print("P/W - ");
        for(int i = 0; i < object; i++)
        	System.out.print(p_w[i] + " ");
        System.out.println();
        int k = 0;
        double sum = 0;
        System.out.println();
        while(m > 0) {
        	if(weight[k] < m) {
        		sum += 1 * profit[k];
        		m = m - weight[k];
        	}
        	else {
        		double x4 = m * profit[k];
        		double x5 = weight[k];
        		double x6 = x4 / x5;
        		sum = sum + x6;
        		m = 0;
        	}
        	k++;
        }
        System.out.println("Final Profit is = " + sum);
	}

}
