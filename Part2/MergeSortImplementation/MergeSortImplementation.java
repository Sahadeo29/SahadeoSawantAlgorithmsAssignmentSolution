package com.GL.GradedAssignment2.Part2.MergeSortImplementation;

import java.util.Scanner;

//Current Stock prices in ascending order
public class MergeSortImplementation {
	Scanner sc = new Scanner(System.in);

	public void printAscendingCSP(double[] csp) {
		System.out.println("Stock prices in ascending order are:");
		for (int i = 0; i < csp.length; i++) {
			System.out.println(csp[i] + " ");
		}
	}

	public void sort(double[] csp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(csp, left, mid);
			sort(csp, mid + 1, right);
			merge(csp, left, mid, right);
		}
	}

	private void merge(double[] csp, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		for (int i = 0; i < n1; ++i) {
			leftArray[i] = csp[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			rightArray[j] = csp[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				csp[k] = leftArray[i];
				i++;
			} else {
				csp[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			csp[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			csp[k] = rightArray[j];
			j++;
			k++;
		}
	}

}