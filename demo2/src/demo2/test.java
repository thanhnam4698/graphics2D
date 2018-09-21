package demo2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.jogamp.nativewindow.util.*;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

public class test implements GLEventListener{
	
	private static GraphicsEnvironment graphicsEnvironment;
	private static boolean isFullScreen = false;
	public static DisplayMode dm, dm_old;
	private static Dimension xgraphic;
	private static Point poitn = new Point(0, 0);

	@Override
	public test(){
		drawable = new GLJPanel();
        drawable.setPreferredSize(new Dimension(700,500));
        drawable.addGLEventListener(this);
        setLayout(new BorderLayout());
        add(drawable, BorderLayout.CENTER);
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frameNumber++;
                drawable.repaint();
            }
        });
        timer.setInitialDelay(500);
        timer.start();
	}
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl2 = drawable.getGL().getGL2();
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl2.glLoadIdentity();
		
		gl2.glColor3f(0.3f, 0.1f, 0);
		gl2.glBegin(GL2.GL_LINES);
        for (int i = 0; i < 15; i++) {
            gl2.glVertex2f(0,0);
            gl2.glVertex2d(Math.cos(i*2*Math.PI/15), Math.sin(i*2*Math.PI/15));
        }
        gl2.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		
		// setup open GL version 2
		JFrame window = new JFrame("Hierarchical Modeling in 2D With Jogl");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new CartAndWindmillJogl2D());
        window.pack();
        window.setVisible(true);
	}
}

