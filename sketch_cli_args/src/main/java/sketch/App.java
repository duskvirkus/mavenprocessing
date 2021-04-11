package sketch;

import org.apache.commons.cli.*;

import processing.core.*;

/**
 * Hello world! Processing App with command line arguments.
 *
 */
public class App extends PApplet
{
	static int WIDTH = 100;
	static int HEIGHT = 100;

  public void settings(){
		size(WIDTH, HEIGHT);
	}
	
	public void draw(){
		background(frameCount % 255);
	}
	
	public static void main(String[] args){

		Options options = new Options();
		options.addOption(Option.builder("w")
			.desc("Width of the sketch.")
			.hasArg(true)
			.longOpt("width")
			.build());
		options.addOption(Option.builder("hi")
			.desc("Height of the sketch.")
			.hasArg(true)
			.longOpt("height")
			.build());

		options.addOption("h", "help", false, "Print this message.");

		CommandLineParser argParser = new DefaultParser();

		try {
			CommandLine line = argParser.parse(options, args);

			if (line.hasOption("help")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "mvn exec:java -Dexec.mainClass=sketch.App  -Dexec.args=\"[options]\"", options );
				System.exit(1);
			}

			if(line.hasOption("width")) {
				WIDTH = Integer.parseInt(line.getOptionValue("width"));
			}
			if(line.hasOption("height")) {
				HEIGHT = Integer.parseInt(line.getOptionValue("height"));
			}

		} catch(ParseException e) {
			System.out.println("Unexpected exception: " + e.getMessage());
			e.printStackTrace();
		}

		String[] processingArgs = {"App"};
		App app = new App();
		PApplet.runSketch(processingArgs, app);
	}
}
