package item_32;

import java.util.EnumSet;
import java.util.Set;

public class Text {
	public enum Style{
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}
	
	//任何集可以传入，但EnumSet显然是最好的
	public void applyStyles(Set<Style> style) {
		//Body goes here
	}
	
	//Sample use
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
