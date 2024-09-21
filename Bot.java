import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot extends JFrame {
	private JTextArea Chatarea = new JTextArea();
	private JTextField chatbox = new JTextField();
	public Bot() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setTitle("CHAT BOT ");
		frame.add(Chatarea);
		frame.add(chatbox);
		Chatarea.setSize(500 , 400);
		Chatarea.setLocation(2, 2);
		chatbox.setSize(400, 30);
		chatbox.setLocation(2, 400);
		chatbox.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {
                    String gtext = chatbox.getText().toLowerCase();
                    Chatarea.append("YOU ->"+gtext + "\n");
                    chatbox.setText("");
                    if (gtext.toLowerCase().contains("hi") || gtext.toLowerCase().contains("hello")) {
                        bot("Hello! How can I assist you today?");
                    } else if (gtext.toLowerCase().contains("how are you")) {
                        bot("I'm functioning well, thank you! How about you?");
                    } else if (gtext.toLowerCase().contains("bye") || gtext.toLowerCase().contains("goodbye")) {
                        bot("Goodbye! Have a great day!");
                    } else if (gtext.toLowerCase().contains("name")) {
                        bot("I'm a chat bot created with Java. Nice to meet you!");
                    } else if (gtext.toLowerCase().contains("weather")) {
                        bot("I'm sorry, I don't have access to real-time weather information. You might want to check a weather app or website for that.");
                    } else if (gtext.toLowerCase().contains("joke")) {
                        String[] jokes = {
                            "Why don't scientists trust atoms? Because they make up everything!",
                            "What do you call a fake noodle? An impasta!",
                            "Why did the scarecrow win an award? He was outstanding in his field!"
                        };
                        int jokeIndex = (int)(Math.random() * jokes.length);
                        bot(jokes[jokeIndex]);
                    } else {
                        int rand = (int)(Math.random() * 4 + 1);
                        switch (rand) {
                            case 1 -> bot("I'm not sure I understand. Could you please rephrase that?");
                            case 2 -> bot("That's an interesting topic! Can you tell me more about it?");
                            case 3 -> bot("I'm always eager to learn. What else can you share about that?");
                            default -> bot("I'm a chat bot with limited knowledge. Is there a specific topic you'd like to discuss?");
                        }
                    }
            }
                });
	}
	private void bot(String string) {
		Chatarea.append("BOT ->"+string+"\n");
	}
	public static void main(String[] args) {
		new Bot();
	}
}