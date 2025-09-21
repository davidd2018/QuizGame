package view;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Splashsreenz {

    private static int barX, barY, barWidth;
    private static int currentX;  // vị trí hiện tại của hình
    private static int targetX;

    public void showSplash() {
        splash sp = new splash();
        sp.setVisible(true);

        barX = sp.pbrTime.getX();
        barY = sp.pbrTime.getY();
        barWidth = sp.pbrTime.getWidth();
        currentX = barX;  // vị trí ban đầu
        targetX = barX;

        // Timer để di chuyển hình từ từ từ trái sang phải 
        Timer moveTimer = new Timer(40, e -> {
            if (currentX < targetX) {
                currentX += 2; // tốc độ dịch chuyển
                if (currentX > targetX) {
                    currentX = targetX;
                }
            } else if (currentX > targetX) {
                currentX -= 2;
                if (currentX < targetX) {
                    currentX = targetX;
                }
            }

            if (sp.lbGif.isVisible()) {
                sp.lbGif.setLocation(
                        currentX - sp.lbGif.getWidth() / 2,
                        barY - sp.lbGif.getHeight()
                );
            }
        });
        moveTimer.start();

        new Thread(()
                -> {
            try {

                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    final int value = i;

                    SwingUtilities.invokeLater(() -> {
                    splash.lbTime.setText(value + "%");
                    splash.pbrTime.setValue(value);

                    if (value == 1) {
                        sp.lbGif.setLocation(
                                    currentX - sp.lbGif.getWidth() / 2,
                                    barY - sp.lbGif.getHeight()
                                 );
                        sp.lbGif.setVisible(true);
                    }

                    if (sp.lbGif.isVisible()) {
                        targetX = barX + (int) ((value / 100.0) * barWidth);
                    }

                    if (value == 100) {
                        Login lg = new Login();
                        sp.lbGif.setVisible(false);
                        sp.setVisible(false);
                        lg.setVisible(true);
                    }

                });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    void setLocation(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
