package kruskal;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.*;

public class DrawGraph extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputControl inputs;

	/*
	 * public DrawGraph(){ this.setTitle("Graphs");
	 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * this.setSize(1000,1000); this.setVisible(true); }
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Graphics2D g2 = (Graphics2D) g;
		// this.setBackground(Color.white);
		((Graphics2D) g).setBackground(Color.white);
		g.setColor(Color.BLACK);
		// g.drawLine(200, 200, 400, 400);
		for (Line line : lines) {
			g.drawLine((int) line.x1 * 2, (int) line.y1 * 2, (int) line.x2 * 2,
					(int) line.y2 * 2);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
			g.drawString(line.N1, ((int) line.x1 * 2) - 5,
					((int) line.y1 * 2) - 5);
			g.drawString(line.N2, ((int) line.x2 * 2) - 5,
					((int) line.y2 * 2) - 5);
			g.drawString(String.valueOf(line.w1),
					(((int) line.x1 * 2 + (int) line.x2 * 2) / 2),
					(((int) line.y1 * 2 + (int) line.y2 * 2) / 2) - 10);
		}
	}

	private static class Line {
		final float x1;
		final float y1;
		final float x2;
		final float y2;
		final float w1;
		final String N1, N2;

		public Line(float x1, float y1, float x2, float y2, float w1,
				String N1, String N2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.w1 = w1;
			this.N1 = N1;
			this.N2 = N2;
		}
	}

	private final LinkedList<Line> lines = new LinkedList<Line>();

	public void addLine(float x1, float x2, float x3, float x4, float w1,
			String N1, String N2) {
		lines.add(new Line(x1, x2, x3, x4, w1, N1, N2));
		repaint();
	}

	public void clearLines() {
		lines.clear();
		repaint();
	}

}