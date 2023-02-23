package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> listLesson = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso?");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da #:" + i + "aula");
			System.out.print("Couteudo ou tarefa (c/t) ?");

			char type = sc.next().charAt(0);
			System.out.print("Titulo : ");
			sc.nextLine();
			String nameLesson = sc.nextLine();

			System.out.print("URL do video : ");
			String url = sc.nextLine();

			if (type == 'c') {
				System.out.print("Duracao em segundos :");
				int durationLesson = sc.nextInt();
				listLesson.add(new Video(nameLesson, url, durationLesson));

			} else {
				System.out.print("Quantidade de questoes: ");
				int quantityLesson = sc.nextInt();
				listLesson.add(new Task(nameLesson, url, quantityLesson));
			}

		}
		System.out.println();
		System.out.println("Duration Total");
		double total = 0.0;
		for (Lesson lesson : listLesson) {
			total += lesson.duration();
		}

		System.out.print("Duracao total do Curso : " + total);

		sc.close();

	}

}
