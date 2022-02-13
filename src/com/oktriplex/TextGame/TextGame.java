package com.oktriplex.TextGame;
import java.util.Random;
import java.util.Scanner;

public class TextGame {
    public static void main(String[] args) {
        // Системные обьекты
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Игровые переменные
        String[] enemies = {"Ассасин", "Воин", "Зомби", "Скелет"};
        int maxEnemyHealth = 75; // макс. количество здоровья врагов
        int enemyAttackDamage = 25; // сколько наносит урона враг при атаке

        // Переменные игрока
        int health = 100; // жизни игрока
        int attackDamage = 50; // сколько игрок наносит урона при атаке
        int numHealthPotions = 3; // количество зелий лечения в начале игры
        int healthPotionHealAmount = 30; // количество здоровья которое прибавляет зелье лечения
        int healthPotionDropChance = 35; // ~ 35% шанс выпадения зелья здоровья

        System.out.println("Добро пожаловать в подземелье!");

            GAME:
            while (true) {
                System.out.println("\n-----------------------------");

                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies[rand.nextInt(enemies.length)];
                System.out.println("\t# " + enemy + " появился! #\n");


                while(enemyHealth > 0) {
                    System.out.println("\tВаше здоровье: " + health);
                    System.out.println("\t" + "Здоровье врага: " + enemyHealth);
                    System.out.println("\n\tЧто вы будете делать?");
                    System.out.println("\t1. Атаковать");
                    System.out.println("\t2. Выпить зелье лечения");
                    System.out.println("\t3. Бежать!");

                    String input = in.nextLine();
                    switch (input) {
                        case "1":
                            int damageDealt = rand.nextInt(attackDamage);
                            int damageTaken = rand.nextInt(enemyAttackDamage);

                            enemyHealth -= damageDealt;
                            health -= damageTaken;
                            System.out.println("\t> Вы атаковали " + enemy + " на " + damageDealt + " урона.");
                            System.out.println("\t> Вы получили " + damageTaken + " урона.");

                            if (health < 1) {
                                System.out.println("\t> Вы получили слишком много урона, вы слишком слабы чтобы продолжить!");
                                break GAME;
                            }
                            break;
                        case "2":
                            if (numHealthPotions > 0) {
                                health += healthPotionHealAmount;
                                numHealthPotions--;
                                System.out.println("\t> Вы выпили зелье лечения, вылечив себя на " + healthPotionHealAmount + "."
                                        + "\n\t> Ваше здоровье сейчас: " + health
                                        + "\n\t> У вас осталось зелий лечения: " + numHealthPotions);


                            } else {
                                System.out.println("\t> У вас не осталось зелий лечения! Сразите врагов чтобы получить их!");
                            }
                            break;
                        case "3":
                            System.out.printf("\tВы убежали от %s!", enemy);
                            continue GAME;
                        default:
                            System.out.println("\tНеверная команда.");
                            System.out.println("-----------------------------");
                            break;
                    }

                } // enemy health cycle
                if (health < 1) {
                    System.out.println("Вы хромаете из подземелья слабым от битвы.");
                    break;
                }
                System.out.println("-----------------------------");
                System.out.println(" # " + enemy + " был повержен! # ");
                System.out.println(" # У вас осталось " + health + " здоровья. # ");
                if (rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println(" # Из " + enemy + " выпало зелье здоровья! #" );
                    System.out.println(" # У вас " + numHealthPotions + " зелий здоровья! # ");
                }
                System.out.println("-----------------------------");
                System.out.println("Что вы будете делать теперь?");
                System.out.println("1. Продолжить сражаться");
                System.out.println("2. Покинуть подземелье");
                String input = in.nextLine();

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Неверная команда.");
                    System.out.println("-----------------------------");
                    input = in.nextLine();
                }

                if (input.equals("1")) {
                    System.out.println("Вы продолжили своё путешествие!");
                }
                else {
                    System.out.println("Вы покинули подземелье, успешно завершив своё путешествие!");
                    break;
                }

            } // running cycle
        System.out.println("\t>##################################<");
        System.out.println("\t>######## СПАСИБО ЗА ИГРУ! ########<");
        System.out.println("\t>##################################<");

    }
}
