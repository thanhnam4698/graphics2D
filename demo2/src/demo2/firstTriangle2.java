package demo2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;


public class firstTriangle2 extends GLJPanel implements GLEventListener{
    
    /**
     * A main routine to create and show a window that contains a
     * panel of type FirstTriangle.  The program ends when the
     * user closes the window.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("The Basic OpenGL RGB Triangle");
        firstTriangle2 panel = new firstTriangle2();
        window.setContentPane(panel);
        window.pack();
        window.setLocation(50,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    /**
     * Constructor for class FirstTriangle.
     */
    
    private GLJPanel drawable;
    private int frameNumber;
    public firstTriangle2() {
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
        timer.setInitialDelay(1000);
        timer.start();
    }
    
    //-------------------- GLEventListener Methods -------------------------

    /**
     * The display method is called when the panel needs to be redrawn.
     * The is where the code goes for drawing the image, using OpenGL commands.
     */
    public void display(GLAutoDrawable drawable) {    
        
        GL2 gl2 = drawable.getGL().getGL2(); // The object that contains all the OpenGL methods.
         
        gl2.glClearColor( 0, 0, 0, 1 );  // (In fact, this is the default.)
        gl2.glClear( GL2.GL_COLOR_BUFFER_BIT );
        
//        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
//        gl2.glColor3d( 1, 1, 0 ); // red
//        gl2.glVertex2d( -0.8, -0.8 );
//        gl2.glColor3d( 0, 1, 1 ); // green
//        gl2.glVertex2d( 0.8, -0.8 );
//        gl2.glColor3d( 1, 0, 1 ); // blue
//        gl2.glVertex2d( 0.8, 0.2 );
//        gl2.glColor3d( 1, 1, 1 ); // blue
//        gl2.glVertex2d( -0.8, 0.2 );
//        gl2.glColor3d( 1, 5, 1 ); // blue
//        gl2.glVertex2d( 0, 0.9 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.8, 0.2 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.8, 0.2 );
//        gl2.glEnd(); 
//        
//        //mai nha
//        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.8, 0.2 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.8, 0.2 );
//        gl2.glEnd();
//        
//        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.69, -0.4 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.69, 0 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.3, 0 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.3, -0.4 );
//        gl2.glEnd();
//        
//        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.69, -0.4);
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.69, 0 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.3, 0 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.3, -0.4 );
//        gl2.glEnd(); 
//        
//        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.25, -0.8 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( -0.25, -0.1 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.25, -0.1 );
//        gl2.glColor3d( 0, 0, 0 ); // blue
//        gl2.glVertex2d( 0.25, -0.8 );
//        gl2.glEnd(); 
        gl2.glColor3f(1, 0.3f, 0.5f);
        gl2.glPushMatrix();
        gl2.glTranslated(0, 0, 0);
        gl2.glScaled(1, 1, 1);
        drawSlippy(gl2);
        gl2.glPopMatrix();
    } // end display()
    private void drawSlippy(GL2 gl2){
    	gl2.glPushMatrix();        
        gl2.glTranslated(0, 0.445f, 0);
        gl2.glScaled(0.3,0.3,1);
        drawSmallCircle(gl2, 0.5);
        gl2.glPopMatrix();
        gl2.glPushMatrix();        
        gl2.glTranslated(0, 0, 0);
        gl2.glScaled(0.3,0.3,1);
        drawBigCircle(gl2, 1);
        gl2.glPopMatrix();
    }
    
    private void drawSmallCircle(GL2 gl2, double radius){
    	gl2.glBegin(GL2.GL_POLYGON);
        for (int d = 0; d < 50; d++) {
            double angle = 2*Math.PI/50 * d;
            gl2.glVertex2d( radius*Math.cos(angle), radius*Math.sin(angle));
        }
        gl2.glEnd();
    }
    private void drawBigCircle(GL2 gl2, double radius){
    	gl2.glBegin(GL2.GL_POLYGON);
        for (int d = 0; d < 32; d++) {
            double angle = 2*Math.PI/32 * d;
            gl2.glVertex2d( radius*Math.cos(angle), radius*Math.sin(angle));
            
        }
        gl2.glEnd();
    }
//    private void drawDisk(GL2 gl2, double radius) {
//        gl2.glBegin(GL2.GL_POLYGON);
//        for (int d = 0; d < 32; d++) {
//            double angle = 2*Math.PI/32 * d;
//            gl2.glVertex2d( radius*Math.cos(angle), radius*Math.sin(angle));
//        }
//        gl2.glEnd();
//    }
    public void init(GLAutoDrawable drawable) {
           // called when the panel is created
    }

    public void dispose(GLAutoDrawable drawable) {
            // called when the panel is being disposed
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
            // called when user resizes the window
    }
    
}
