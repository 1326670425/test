package Jump;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ocr {
	public static void main(String[] args)throws IOException{
		BufferedImage bi = (BufferedImage)ImageIO.read(Ocr.class.getResource("test.png"));
		
		int width = bi.getWidth();
		int height = bi.getHeight();
		System.out.println(width+"\t"+height);
		int backColor  = bi.getRGB(1, 300);
		
		int RED = 0xff & (backColor>>16);
		int GREEN = 0xff & (backColor>>8);
		int BLUE = 0xff & backColor;
		
/*		int REDP = 63;
		int GREENP = 61;
		int BLUEP = 83;*/
		
		int red,green,blue;
		int tmp = 0;
		int nextColor = 0;
		int nextYMax = 0;
		int nextYMin = 0;
		boolean flag1 = false;
		boolean flag2 = false;

		for(int i=300;i<height;i++){
			
			for(int j=0;j<width;j++){
				tmp = bi.getRGB(j, i);
				red = 0xff & (tmp>>16);
				green = 0xff & (tmp>>8);
				blue = 0xff & tmp;
				
				if(Math.abs(RED-red)>10&&Math.abs(GREEN-green)>10&&Math.abs(BLUE-blue)>10){
					System.out.println(j+"\t"+i);
					nextYMin = i;
					nextColor = tmp;
					int k;
					for(k=i;nextColor == tmp;k++){
						tmp=bi.getRGB(j, k);
					}
					nextYMax = k;
					System.out.println(j+"\t"+(nextYMax+nextYMin)/2);
					flag1 = true;
					break;
				}
			}
			if(flag1)
				break;
		}
		
		System.out.println(nextYMin);

		for(int k=nextYMin+1;k<height;k++){
			for(int j=0;j<width;j++){
				tmp = bi.getRGB(j, k);
				red = 0xff & (tmp>>16);
				green = 0xff & (tmp>>8);
				blue = 0xff & tmp;
				if(red==63 && green==61 && blue == 83){
					System.out.println(j+5+"\t"+(k+190));
					flag2 = true;
					break;
				}
			}
			if(flag2){
				break;
			}
				
		}	
		
	}
}
