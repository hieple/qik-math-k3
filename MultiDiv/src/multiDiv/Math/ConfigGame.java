package multiDiv.Math;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Context;

public class ConfigGame {

	public static int numOfTest = 10;
	public static int durationOfTest = 30; // seconds
	public static int maxNumber = 12;
	public static final int D_O_T = 30;
	public static final int N_O_T = 10;
	public static final int N_U_B = 10;
	public static boolean divGame = true;
	public static boolean mulGame = true;
	public static boolean addGame = true;
	public static boolean subGame = true;
	public static boolean gameStart = false;
	public static int elapseTime = 0;
	public static int goodResult = 0;
	public static int badResult = 0;
	public static String Result = "";
	static String fnResult = "result.dat";
	static String fnConfig = "config.dat";

	public static String HourMinuteSecond(int seconds) {
		int s = seconds % 60;
		int m = seconds / 60;
		int h = 0;
		if (m >= 60) {
			h = m / 60;
			m = m % 60;
		}
		return String.format("%d:%2d:%2d", h, m, s).replace(' ', '0');
	}

	public static void SaveResult(Context Cnt, String Rs) {
		String[] Fn = Cnt.fileList();
		Arrays.sort(Fn);
		int index = Arrays.binarySearch(Fn, fnResult);
		FileOutputStream fos = null;
		if (index < 0)
			try {
				fos = Cnt.openFileOutput(fnResult, Context.MODE_PRIVATE);
				fos.write(Rs.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			try {
				fos = Cnt.openFileOutput(fnResult, Context.MODE_APPEND);
				fos.write(Rs.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static ArrayList<String> GetResult(Context Cnt) {
		ArrayList<String> Rs = new ArrayList<String>();
		String[] Fn = Cnt.fileList();
		Arrays.sort(Fn);
		int index = Arrays.binarySearch(Fn, fnResult);
		if (index > 0)
			try {
				FileInputStream fos = Cnt.openFileInput(fnResult);
				DataInputStream din = new DataInputStream(fos);
				BufferedReader bre = new BufferedReader(new InputStreamReader(
						din));
				String Ln;
				while ((Ln = bre.readLine()) != null) {
					Rs.add(0, Ln); // reversed order
				}

				bre.close();
				din.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return Rs;
	}

	public static void ClearData(Context Cnt) {
		String[] Fn = Cnt.fileList();
		Arrays.sort(Fn);
		int index = Arrays.binarySearch(Fn, fnResult);
		if (index >= 0)
			Cnt.deleteFile(fnResult);
	}

	public static String ReadConfig(Context Cnt) {
		String[] Fn = Cnt.fileList();
		Arrays.sort(Fn);
		int index = Arrays.binarySearch(Fn, fnConfig);
		String Ln = "";
		if (index >= 0) {
			try {
				FileInputStream fos = Cnt.openFileInput(fnConfig);
				DataInputStream din = new DataInputStream(fos);
				BufferedReader bre = new BufferedReader(new InputStreamReader(
						din));
				Ln = bre.readLine();
				bre.close();
				din.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String[] Info = Ln.split("\\|");
			if (Info.length == 7) {
				addGame = Info[0].equals("Y");
				subGame = Info[1].equals("Y");
				mulGame = Info[2].equals("Y");
				divGame = Info[3].equals("Y");
				numOfTest = Integer.parseInt(Info[4]);
				durationOfTest = Integer.parseInt(Info[5]);
				maxNumber = Integer.parseInt(Info[6]);
			}
		}
		return Ln;
	}

	public static void SaveConfig(Context Cnt) {

		String Rs = String.format("%s|%s|%s|%s|%d|%d|%d\n",
				addGame ? "Y" : "N", subGame ? "Y" : "N", mulGame ? "Y" : "N",
				divGame ? "Y" : "N", numOfTest, durationOfTest, maxNumber);

		try {
			FileOutputStream fos = Cnt.openFileOutput(fnConfig,
					Context.MODE_PRIVATE);
			fos.write(Rs.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
