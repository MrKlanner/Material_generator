package ru.rbc.kskabort;
import java.util.Random;

public class vocab {
    public static String text_Creator(int n_paragraph /*количество абзацев*/,
                                      int n_min_sentence /*минимальное кол-во слов в предложении*/,
                                      int n_max_sentence /*максимальное кол-во слов в предложении*/,
                                      int n_min_sen_in_ph /*количество предложений в абзаце*/,
                                      int n_max_sen_in_ph /*количество предложений в абзаце*/) {
        String[] dict = {"лес", "трава", "шум", "фонарь", "лень",
                "лоза", "Антоха", "череда", "лупа", "капилляр",
                "слова", "бан", "кек", "аптека", "ортштейн",
                "чебурек", "фраджипэн", "тест", "бурозём"};
        String text = "", text1 = "";
        int ph = 0; // счётчик абзацев
        int i = 0; // счётчик предложений
        int n_sent = 0; //счётчик слов в последнем предложении

        int n_w_sentence = 0; //количество слов в предолжении
        int n_sen_in_ph = 0; //количество предолжений в абзаце

        Random random = new Random();
        while (ph < n_paragraph) /*формирование абзацев*/
            {
            n_sen_in_ph = n_min_sen_in_ph + random.nextInt(n_max_sen_in_ph - n_min_sen_in_ph); //рандомное кол-во предложений в абзаце

            while (i < n_sen_in_ph) /*формирование предложений*/
                {
                n_w_sentence = n_min_sentence + random.nextInt(n_max_sentence - n_min_sentence); //рандомное кол-во слов в предложениях в пределах значений

                for (int j = 0; j <= n_w_sentence; j++) /*рефакторинг предложения*/
                    {
                    text1 = (dict[(int) (random.nextInt(dict.length - 1))]); //рандомное слово из массива
                    if (j == 0)
                        text1 = text1.substring(0, 1).toUpperCase() + text1.substring(1);
                    else if (j == n_w_sentence) {
                        text = text.substring(0,text.length()-1).concat(". ");
                        break;
                    }
                    n_sent++;
                    text = text.concat(text1).concat(" "); //добавление слова к предложению
                }
                i++;
            }
            text = text.concat("\n\n");
            ph++;
            i = 0;
        }
        return text;
    }
}
