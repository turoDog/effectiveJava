package item_32;

import java.util.EnumSet;
import java.util.Set;

public class Text {
	public enum Style{
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}
	
	//�κμ����Դ��룬��EnumSet��Ȼ����õ�
	public void applyStyles(Set<Style> style) {
		//Body goes here
	}
	
	//Sample use
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
