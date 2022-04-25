package java1.homework4;

import java.util.Random;
import java.util.Scanner;


public class ConsoleApp {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static String playerName = "Lancelot";
    public static char player = '@';
    public static int playerHealth = 100;
    public static int playerCoins = 0;
    public static int playerExp = 0;
    public static int playerPosX;
    public static int playerPosY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveDown = 2;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;

    public static char enemy = 'E';
    public static char hiddenEnemy = ' ';
    public static int enemyHealth;
    public static int enemyPower;
    public static int enemiesCount;
    public static int enemyValueMin = 10;
    public static int enemyValueMax = 30;

    public static int mapWidth;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 6;
    public static char[][] map;
    public static char emptyCell = '_';

    public static char coinCell = 'o';
    public static int coinsCount;

    public static void main(String[] args) {
        createMap();

        spawnPlayer();
        spawnEnemies();
        spawnCoins();

        while (true) {
            showMap();
            playerMoveAction();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead. Count coins = " + playerCoins);
                break;
            }

            if (!isEnemyExist()) {
                System.out.println(playerName + " is win. Count coins = " + playerCoins);
                break;
            }
        }
        showMap();
        System.out.println("Game over!");
    }

    public static void createMap() {
        mapWidth = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }
        System.out.println("Create map [" + mapWidth + "x" + mapHeight + "]");
    }

    public static void showMap() {
        System.out.println("========== MAP ==========");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    public static void spawnPlayer() {
        playerPosX = randomValue(0, mapWidth - 1);
        playerPosY = randomValue(0, mapHeight - 1);
        map[playerPosY][playerPosX] = player;
        System.out.println(playerName + " has spawn in [" + playerPosY + ":" + playerPosX + "]");
    }

    public static void spawnEnemies() {
        enemyHealth = randomValue(enemyValueMin, enemyValueMax);
        enemyPower = randomValue(enemyValueMin, enemyValueMax);

        enemiesCount = (mapWidth + mapHeight) / 2; //random math.formula

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesCount; i++) {

            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (!isCellClear(enemyPosX, enemyPosY));
            map[enemyPosY][enemyPosX] = hiddenEnemy;
        }
        System.out.println(("Enemy count: " + enemiesCount + ". HP=" + enemyHealth + ", PWR=" + enemyPower));
    }

    public static void spawnCoins(){

        coinsCount = (mapWidth + mapHeight) / 2;

        int coinPosX;
        int coinPosY;

        for (int i = 1; i < coinsCount; i++) {

            do {
                coinPosX = random.nextInt(mapWidth);
                coinPosY = random.nextInt(mapHeight);
            }while (!isCellClear(coinPosX, coinPosY));
            map[coinPosY][coinPosX] = coinCell;
        }
    }

    public static void playerMoveAction() {
        int playerLastPositionX = playerPosX;
        int playerLastPositionY = playerPosY;

        int playerMoveCode;

        do {
            System.out.print("Enter destination: (UP-" + playerMoveUp + "|DOWN-" + playerMoveDown +
                    "|LEFT-" + playerMoveLeft + "|RIGHT-" + playerMoveRight + ") > ");
            playerMoveCode = scanner.nextInt();

            switch (playerMoveCode) {
                case playerMoveUp:
                    playerPosY -= 1;
                    break;
                case playerMoveDown:
                    playerPosY += 1;
                    break;
                case playerMoveLeft:
                    playerPosX -= 1;
                    break;
                case playerMoveRight:
                    playerPosX += 1;
                    break;
                default:
                    System.out.println("Please enter valid move action key! =)");
                    break;
            }

        } while (!isValidPlayerMove(playerLastPositionX, playerLastPositionY, playerPosX, playerPosY));

        playerNextCellAction();

        if (playerLastPositionX == playerPosX && playerLastPositionY == playerPosY){

            map[playerPosY][playerPosX] = player;
            //map[playerLastPositionY][playerLastPositionX] = emptyCell;
        }else {
            map[playerPosY][playerPosX] = player;
            map[playerLastPositionY][playerLastPositionX] = emptyCell;
        }

    }

    public static boolean isValidPlayerMove(int lastX, int lastY, int nextX, int nextY) {
        if (isCellValid(nextX, nextY)) {
            System.out.println(playerName + " has move to [" + nextY + ":" + nextX + "]");
            return true;
        } else {
            System.out.println(playerName + " move to [" + nextY + ":" + nextX + "] invalid");
            playerPosX = lastX;
            playerPosY = lastY;
            return false;
        }
    }

    public static void playerNextCellAction() {
        if (map[playerPosY][playerPosX] == hiddenEnemy) {
            playerHealth -= enemyPower;
            enemiesCount--;
            playerExp += 250;
            System.out.println(playerName + " get damage " + enemyPower + ". " + playerName + " HP= " + playerHealth);
        }
        if (map[playerPosY][playerPosX] == coinCell) {
            int count = randomValue(100, 300);
            playerCoins += count;
            System.out.println(playerName + " get " + count + " coins. " + playerName + " coins = " + playerCoins);
        }
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isCellClear(int x, int y) {
        return map[y][x] == emptyCell;
    }

    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean isPlayerAlive() {
        return playerHealth > 0;
    }

    public static boolean isEnemyExist() {
        return enemiesCount > 0;
    }
}
