package kr.s28.iostream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MovieMain {
	/*
	 * 메뉴 : 1. 영화정보입력, 2.영화정보출력, 3.파일생성, 4.파일읽기, 5.종료
	 * 메소드명 : 메뉴 callMenu()
	 *            영화정보입력 inputMovie()
	 *            영화정보출력 printMovie()
	 *            파일생성 createFile() -FileReader
	 *            파일읽기 readFile() -FileWriter
	 * 상영시간 입력시 조건 체크 : 0보다 크게 입력하세요.
	 */

	BufferedReader br;
	ArrayList<Movie> movies = new ArrayList<Movie>();

	//생성자
	public MovieMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}

	//메뉴호출
	public void callMenu() throws IOException {
		while (true) {
			System.out.print("메뉴 : 1. 영화정보입력, 2.영화정보출력, 3.파일생성, 4.파일읽기, 5.종료 > ");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num == 1) {
					inputMovie();
				} else if (num == 2) {
					printMovie();
				} else if (num == 3) {
					createFile();
				} else if (num == 4) {
					readFile();
				} else if (num == 5) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("메뉴를 잘못 입력했습니다");
				}

			} catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자로 입력해주세요");
			}
		}
	}

	//영화정보입력
	public void inputMovie() throws IOException {
		Movie mv = new Movie();

		System.out.print("영화 제목: ");
		mv.setName(br.readLine());
		System.out.print("제작연도: ");
		mv.setCreate_year(br.readLine());
		System.out.print("감독: ");
		mv.setDirector(br.readLine());
		System.out.print("배우: ");
		mv.setActor(br.readLine());
		System.out.print("상영시간: ");
		mv.setTime(checkTime());

		movies.add(mv);

	}

	//checkTime()
	public int checkTime() throws IOException {
		int time = 0;
		while (true) {
			try {
				time = Integer.parseInt(br.readLine());
				if (time <= 0) {
					throw new TimeUnderZeroException("상영시간은 0보다 크게 입력해주세요");
				}
				return time;

			} catch (TimeUnderZeroException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력해주세요");
			}
		}
	}

	//영화정보출력
	public void printMovie() {
		for (Movie movie : movies) {
			System.out.println("영화제목: " + movie.getName());
			System.out.println("제작연도: " + movie.getCreate_year());
			System.out.println("감독: " + movie.getDirector());
			System.out.println("배우: " + movie.getActor());
			System.out.println("상영시간: " + movie.getTime());
		}
	}

	//파일생성
	public void createFile() throws IOException {
		FileWriter fw = new FileWriter("영화정보.txt", true);

		String movieList = "";
		try {
			if (!movies.isEmpty()) {
				for (Movie movie : movies) {
					movieList += "영화제목: " + movie.getName() + "\n";
					movieList += "제작연도: " + movie.getCreate_year() + "\n";
					movieList += "감독: " + movie.getDirector() + "\n";
					movieList += "배우: " + movie.getActor() + "\n";
					movieList += "상영시간: " + movie.getTime() + "\n";
					movieList += "\n";
				}
				fw.write(movieList);
				fw.flush();
				System.out.println("파일을 생성하고 내용을 기술했습니다.");
			} else {
				throw new MovieListNotFoundException("영화정보를 먼저 입력해주세요.");
			}
		} catch (MovieListNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
				}
			}
		}
	}

	//파일출력
	public void readFile() throws IOException {
		FileReader fr = null;
		int readChar;

		try {
			fr = new FileReader("영화정보.txt");
			while ((readChar = fr.read()) != -1) {
				System.out.print((char) readChar);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다. 파일을 먼저 생성해주세요.");
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}
		}

	}

	public static void main(String[] args) {
		new MovieMain();
	}
}
