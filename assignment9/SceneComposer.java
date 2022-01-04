package assignment9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import assignment9.scenes.Bubbles;
import assignment9.scenes.Circle;
import assignment9.scenes.Clear;
import assignment9.scenes.Forest;
import assignment9.scenes.Leaves;
import assignment9.scenes.Line;
import assignment9.scenes.Poly;
import assignment9.scenes.Sequence;
import assignment9.scenes.Square;
import assignment9.scenes.ifs.Dragon;
import assignment9.scenes.ifs.IFS;
import assignment9.scenes.ifs.Tree;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class SceneComposer {



	
	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);

		// Note: Double Buffering is enabled!  
		//       You'll need to call show() to update the screen.
		//       In most cases you'll want to call show() after you've drawn something
		StdDraw.enableDoubleBuffering();


		//
		// for demo only, remove this code and write your own to do what
		//   is needed for this assignment


		Map<String, Drawable> StringToDrawable = new HashMap<String, Drawable>();
		
		StringToDrawable.put("forest1", new Forest(10));
		StringToDrawable.put("forest2", new Forest(20));
		StringToDrawable.put("forest3", new Forest(60));
		StringToDrawable.put("forest4", new Forest(100));
		StringToDrawable.put("leaves1", new Leaves(10));
		StringToDrawable.put("leaves2", new Leaves(20));
		StringToDrawable.put("leaves3", new Leaves(60));
		StringToDrawable.put("leaves4", new Leaves(100));
		StringToDrawable.put("bubbles1", new Bubbles(10));
		StringToDrawable.put("bubbles2", new Bubbles(20));
		StringToDrawable.put("bubbles3", new Bubbles(60));
		StringToDrawable.put("bubbles4", new Bubbles(100));
		StringToDrawable.put("dragon1", new Dragon(0,0,1));
		StringToDrawable.put("dragon2", new Dragon(0,.3,1));
		StringToDrawable.put("dragon3", new Dragon(.3,.7,1));
		StringToDrawable.put("dragon4", new Dragon(.8,-.7,1));
		StringToDrawable.put("dragon5", new Dragon(.8,.2,1));
		StringToDrawable.put("dragon6", new Dragon(-.4,.2,1));
		StringToDrawable.put("dragon7", new Dragon(-.6,.2,1));
		StringToDrawable.put("tree1", new Tree(.5,-.5,.5));
		StringToDrawable.put("tree2", new Tree(0,0,1));
		StringToDrawable.put("tree3", new Tree(.3,.3,1));
		StringToDrawable.put("tree4", new Tree(-.4,-.2,1));
		StringToDrawable.put("tree5", new Tree(.1,.2,1));
		StringToDrawable.put("line1", new Line());
		StringToDrawable.put("line2", new Line());
		StringToDrawable.put("line3", new Line());
		StringToDrawable.put("line4", new Line());
		StringToDrawable.put("line5", new Line());
		StringToDrawable.put("line6", new Line());
		StringToDrawable.put("line7", new Line());
		StringToDrawable.put("line8", new Line());
		StringToDrawable.put("line9", new Line());
		StringToDrawable.put("poly1", new Poly());
		StringToDrawable.put("poly2", new Poly());
		StringToDrawable.put("poly3", new Poly());
		StringToDrawable.put("poly4", new Poly());
		StringToDrawable.put("poly5", new Poly());
		StringToDrawable.put("poly6", new Poly());
		StringToDrawable.put("poly7", new Poly());
		StringToDrawable.put("poly8", new Poly());
		StringToDrawable.put("poly9", new Poly());
		StringToDrawable.put("Square1", new Square(.25,.25,.25));
		StringToDrawable.put("Square2", new Square(-.25,-.25,.25));
		StringToDrawable.put("Square3", new Square(0,0,.3));
		StringToDrawable.put("Square4", new Square(.5,.5,.3));




		

		

		List<Drawable> initList = new ArrayList<Drawable>();
		initList.add(new Forest(175));
		initList.add( new Leaves(130));
		Sequence initDrawable = new Sequence(initList);
		StringToDrawable.put("init", initDrawable);
		StringToDrawable.get("init");


		//Map<String, String> Display = new HashMap<String, String>();
		for(String key : StringToDrawable.keySet()) {
			System.out.println(key);
		}
		while(true) {
			StdDraw.show();
			StdDraw.pause(10);
			String resp = ap.nextString(" Enter: ");
			if (resp.equals("end")) {
				System.exit(1);
			}
			if (resp.equals("clear")) {
				StdDraw.clear();
			}
			if(StringToDrawable.containsKey(resp)) {
				StringToDrawable.get(resp).draw();
			}
			if (resp.equals("ron")) {
				StdDraw.clear();
				List<Drawable> newList = new LinkedList<Drawable>();
				while(true) {
					String recordingResponse = ap.nextString("End or add");
					if (recordingResponse.equals("roff")) {
						break;
					}
					if(StringToDrawable.containsKey(recordingResponse)) {
						newList.add(StringToDrawable.get(recordingResponse));
						StdDraw.show();
						StringToDrawable.get(recordingResponse).draw();
						StdDraw.show();
					}
					
				}
				String name = ap.nextString("name?");

				Sequence drawable = new Sequence(newList);
				StringToDrawable.put(name, drawable);
			}
			
		}
		/*while(true) {
			StdDraw.show();
			StdDraw.pause(10);
			for (int i=0; i < 10; ++i) {
				Forest f = new Forest(5);
				f.draw(); f.draw(); f.draw(); f.draw();
				Leaves l = new Leaves(5);
				l.draw(); l.draw();
			}
			Bubbles b = new Bubbles(10);
			b.draw();
			StdDraw.show();
			StdDraw.pause(10);
			String resp = ap.nextString("Again?");
			if (resp.equals("no")) {
				break;
			}
			else {
				new Clear().draw();
			}
		}
		 */
		//
		// end of demo code
		//
	}

}
