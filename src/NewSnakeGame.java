import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewSnakeGame{
    public static void main(String[] args) throws Exception{
        
        SnakeFunction sf = new SnakeFunction();
        SnakeBody snake = new SnakeBody();

        new InputJoystick();
        int[][] board = sf.createBoard( 15, 15);
        snake.addBody( board );
        snake.addBody( board );
        snake.addBody( board );
        snake.generateFood(board);

        while( !SnakeBody.gameOver ){
            sf.printBoard(board);	
            Thread.sleep( 500 );
            board = snake.movement(board);
        }

        System.out.println("\n\n" + String.format("%35s", " ") +"!!! GAME OVER !!!\n");
        System.out.println("\n" + String.format("%35s", " ") + " YOUR SCORE  : " + (SnakeBody.bodyLength - 3) + "\n\n");

        System.exit(0);

    }	
}

class InputJoystick extends JFrame implements KeyListener{

    JButton up, down, left, right;

    InputJoystick(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize( 400, 400 );
        this.getContentPane().setBackground(Color.black);
        this.setLocation( 1150, 0 );
        this.setLayout(null);
        this.addKeyListener(this);

        up = new JButton("UP");
        this.add(up);
        up.addKeyListener(this);
        up.setBounds( 150, 50, 100, 100 );
        up.setFocusable(false);
        up.setBackground(Color.red);
        up.setFont(new Font( "Calibri", Font.BOLD, 20));
        
        down = new JButton("DOWN");
        this.add(down);
        down.addKeyListener(this);
        down.setBounds( 150, 250, 100, 100 );
        down.setFocusable(false);
        down.setBackground(Color.red);
        down.setFont(new Font( "Calibri", Font.BOLD, 20));
        
        left = new JButton("LEFT");
        this.add(left);
        left.addKeyListener(this);
        left.setBounds( 50, 150, 100, 100 );
        left.setFocusable(false);
        left.setBackground(Color.red);
        left.setFont(new Font( "Calibri", Font.BOLD, 20));
        
        right = new JButton("RIGHT");
        this.add(right);
        right.addKeyListener(this);
        right.setBounds( 250, 150, 100, 100 );
        right.setFocusable(false);
        right.setBackground(Color.red);
        right.setFont(new Font( "Calibri", Font.BOLD, 20));

        this.setVisible(true);

    }

    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == 37 ){
            SnakeBody.direction = "L";
            left.setBackground(Color.green);
        }else if( e.getKeyCode() == 38 ){
            SnakeBody.direction = "U";
            up.setBackground(Color.green);
        }else if( e.getKeyCode() == 39 ){
            SnakeBody.direction = "R";
            right.setBackground(Color.green);
        }else if( e.getKeyCode() == 40 ){
            SnakeBody.direction = "D";
            down.setBackground(Color.green);
        }
    }

    public void keyReleased(KeyEvent e) {
        if( e.getKeyCode() == 37 ){
            left.setBackground(Color.red);
        }else if( e.getKeyCode() == 38 ){
            up.setBackground(Color.red);
        }else if( e.getKeyCode() == 39 ){
            right.setBackground(Color.red);
        }else if( e.getKeyCode() == 40 ){
            down.setBackground(Color.red);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}


class SnakeFunction{

    public int[][] createBoard( int x, int y){
        int[][] board = new int[x][y];
        for( int i = 0; i < x; i++ ){
            for( int j = 0; j < y; j++ ){
                if( i == 0 || i == x - 1 || j == 0 || j == y - 1 ){
                    board[i][j] = 10;
                }
            }
        }
        return board;
    }

    public void printBoard( int[][] board){
        System.out.println("\n\n");
        for( int i = 0; i < board.length; i++ ){
            System.out.print(String.format("%35s", ""));
            for( int j = 0; j < board[0].length; j++ ){
                if( ( i == 0 && ( j == 0 || j == board[0].length - 1  ) || ( i == board.length -1 &&  ( j == 0 || j == board[0].length - 1 ) ) ) ){
                    System.out.print("+");
                }else if( i == 0 || i == board.length - 1 ){
                    System.out.print("-");
                }else if( j == 0 || j == board[0].length - 1 ){
                    System.out.print("|");
                }else if( board[i][j] == 1 ){
                    System.out.print("O");
                }else if( board[i][j] == 2 ){
                    System.out.print("X");
                }else if( board[i][j] == -1 ){
                    System.out.print("0");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }    

}

class SnakeBody{

	static int prevTaili, prevTailj, bodyLength = 0, fi, fj;
	static boolean gameOver = false;
	static Body head, tail;
	static String direction = "R";
	
	class Body{

		Body nextPart;
		Body prevPart;
		int i;
		int j;
		int bodycount;

		Body( int i, int j, int bodyCount ){
			this.i = i;
			this.j = j;
			this.bodycount = bodyCount;
		}

	}

	void addBody( int[][] board  ){
		bodyLength++;
		if( tail == null ){
			head = tail = new Body( (int)board.length/2, (int)board[0].length/2, bodyLength);
			board[(int)board.length/2][(int)board[0].length/2] = 1;
		}else{
			Body newBody = new Body(prevTaili, prevTailj,bodyLength);
			newBody.nextPart = tail;
			tail.prevPart = newBody;
			tail = newBody;
		}
	}

    public int[][] movement( int[][] board ){
        Body tempBody = tail;
		int tempi = prevTaili, tempj = prevTailj;
		prevTaili = tail.i;
		prevTailj = tail.j;
        while( true ){
			if( tempBody == head ){
				if( direction.compareToIgnoreCase("R") == 0 ){
					head.j += 1;
				}else if( direction.compareToIgnoreCase("U") == 0 ){
					head.i -= 1;
				}else if( direction.compareToIgnoreCase("L") == 0 ){
					head.j -= 1;
				}else if( direction.compareToIgnoreCase("D") == 0 ){
					head.i += 1;
				}
				break;
			}
			tempBody.i = tempBody.nextPart.i;
			tempBody.j = tempBody.nextPart.j;
			tempBody = tempBody.nextPart;
		}
    
        if( head.i > board.length-2 || head.j > board[0].length - 2 || head.i < 1 || head.j < 1 ){
			gameOver = true;
			return new int[board.length][board[0].length];
		}

		if( board[head.i][head.j] > 0 ){
			gameOver = true;
			return new int[board.length][board[0].length];
		}
        
        if( board[head.i][head.j] == -1 ){
			generateFood( board );
			addBody(board);
			prevTaili = tempi;
			prevTailj = tempj;
		}

        //UPDATING NEW BOARD
        board = new int[board.length][board[0].length];
		board[fi][fj] = -1;

        tempBody = tail;
		while( tempBody != null ){
            if( tempBody.bodycount == 1 ){
                board[tempBody.i][tempBody.j] = 1;
            }else{
                board[tempBody.i][tempBody.j] = 2;
            }
			tempBody = tempBody.nextPart;
		}
		return board;
    }

	void generateFood( int[][] board ){
		do{
			fi = 1 + (int)(Math.random() * (board.length - 2) );
			fj = 1 + (int)(Math.random() * (board[0].length  - 2) );
			if( bodyLength == 1 && ( ( fi == (int)board.length/2 - 1 || fi == (int)board.length/2 || fi == (int)board.length/2 + 1) && ( fj == (int)board[0].length/2 - 1|| fj == (int)board[0].length/2 || fj == (int)board[0].length/2 + 1 ) ) ){
				continue;
			}
		}while( board[fi][fj] != 0 );
		board[fi][fj] = -1;
	}

}