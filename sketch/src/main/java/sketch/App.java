package sketch;

import processing.core.*;

/**
 * Hello world! Processing App
 *
 */
public class App extends PApplet
{
    public void settings(){
		size(500, 500);
	}
	
	public void draw(){
		background(frameCount % 255);
	}
	
	public static void main(String[] args){
		String[] processingArgs = {"App"};
		App app = new App();
		PApplet.runSketch(processingArgs, app);
	}
}
