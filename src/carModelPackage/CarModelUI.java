/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carModelPackage;
import carModelPackage.Car;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
/**
 *
 * @author mvideo
 */
public class CarModelUI extends javax.swing.JFrame {

    /**
     * Creates new form CarModelUI
     */
    public CarModelUI() {
        initComponents();
        this.auto = new Car(126, 1326, 0.28, 0.025);
        jLabelMaxSpeed.setText(String.format("%.5g%n",auto.getMaxSpeed()) + " км/ч");
        jProgressBar.setMaximum((int)auto.getMaxSpeed());
        this.timer = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!jToggleButtonSwitcher.isSelected()){
                    // получаем значение счетчика умножения времени
                    double multParametr = Double.parseDouble(spnTimeMult.getValue().toString());
                    // получаем значение одометра
                    double distance = auto.getTripDistance();
                    // вызываем метод tick() отвечающий за пересчет значений сопротивления воздуху от скорости автомобиля
                    // и расчет параметров скорости, пробега автомобиля
                    auto.tick(multParametr, jToggleButtonGas.isSelected(), jToggleButtonBrake.isSelected());
                    jLabelDistanceValue.setText(String.valueOf(Math.floor(distance)) + " м");
                    jLabelSpeedValue.setText(String.valueOf(Math.floor(auto.getSpeedInKmh())) + " км/ч");

                    jLabelAirForseValue.setText(String.format("%.5g%n",(auto.getAirResistanceForceValue()/1326))+ " м/c²");
                    jLabelRollingResistanceValue.setText(String.format("%.5g%n",(auto.getRollingResistanceForseValue()/1326))+ " м/c²");
                    jLabelThrustForstVlaue.setText(String.format("%.5g%n",(auto.getThrustForseValue()/1326)) + " м/c²");
                    jLabelTimeValue.setText(String.valueOf(auto.getTripTime()) + " сек.");
                    jProgressBar.setValue((int)auto.getSpeedInKmh());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelModelVisual = new javax.swing.JPanel();
        jLabelSpeed = new javax.swing.JLabel();
        jLabelSpeedValue = new javax.swing.JLabel();
        jLabelDistance = new javax.swing.JLabel();
        jLabelDistanceValue = new javax.swing.JLabel();
        jLabelThrustForst = new javax.swing.JLabel();
        jLabelThrustForstVlaue = new javax.swing.JLabel();
        jLabelAirForse = new javax.swing.JLabel();
        jLabelAirForseValue = new javax.swing.JLabel();
        jLabelRollingResistance = new javax.swing.JLabel();
        jLabelRollingResistanceValue = new javax.swing.JLabel();
        jToggleButtonSwitcher = new javax.swing.JToggleButton();
        jProgressBar = new javax.swing.JProgressBar();
        jLabelMinSpeed = new javax.swing.JLabel();
        jLabelMaxSpeed = new javax.swing.JLabel();
        jToggleButtonGas = new javax.swing.JToggleButton();
        jToggleButtonBrake = new javax.swing.JToggleButton();
        jPanelModelConfig = new javax.swing.JPanel();
        jButtonStop = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jLabelTimeMult = new javax.swing.JLabel();
        spnTimeMult = new javax.swing.JSpinner();
        jLabelTime = new javax.swing.JLabel();
        jLabelTimeValue = new javax.swing.JLabel();
        jPanelModelParametrs = new javax.swing.JPanel();
        jSpinnerPower = new javax.swing.JSpinner();
        jSpinnerWeight = new javax.swing.JSpinner();
        jSpinnerAirC = new javax.swing.JSpinner();
        jSpinnerRollingC = new javax.swing.JSpinner();
        jLabelPower = new javax.swing.JLabel();
        jLabelPower1 = new javax.swing.JLabel();
        jLabelPower2 = new javax.swing.JLabel();
        jLabelPower3 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelModelVisual.setBorder(javax.swing.BorderFactory.createTitledBorder(" Визуализация процесса"));

        jLabelSpeed.setText("Скорость:");

        jLabelSpeedValue.setText("0 км/ч");

        jLabelDistance.setText("Пробег:");

        jLabelDistanceValue.setText("0 км");

        jLabelThrustForst.setText("Ускорение авто:");

        jLabelThrustForstVlaue.setText("0 м/c²");

        jLabelAirForse.setText("Сопротивлени ветра:");

        jLabelAirForseValue.setText("0 м/c²");

        jLabelRollingResistance.setText("Сопротивление трению:");

        jLabelRollingResistanceValue.setText("0 м/c²");

        jToggleButtonSwitcher.setText("Выкл");

        jLabelMinSpeed.setText("0 км/ч");

        jLabelMaxSpeed.setText("0 км/ч");

        jToggleButtonGas.setText("Газ");
        jToggleButtonGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonGasActionPerformed(evt);
            }
        });

        jToggleButtonBrake.setText("Тормоз");
        jToggleButtonBrake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBrakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModelVisualLayout = new javax.swing.GroupLayout(jPanelModelVisual);
        jPanelModelVisual.setLayout(jPanelModelVisualLayout);
        jPanelModelVisualLayout.setHorizontalGroup(
            jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                        .addComponent(jLabelMinSpeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMaxSpeed))
                    .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                        .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                                .addComponent(jLabelSpeed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSpeedValue))
                            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                                .addComponent(jLabelDistance)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDistanceValue))
                            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                                .addComponent(jLabelThrustForst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelThrustForstVlaue))
                            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                                .addComponent(jLabelAirForse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAirForseValue))
                            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                                .addComponent(jLabelRollingResistance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRollingResistanceValue)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButtonSwitcher, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jToggleButtonGas, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonBrake)))
                .addContainerGap())
        );
        jPanelModelVisualLayout.setVerticalGroup(
            jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModelVisualLayout.createSequentialGroup()
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpeed)
                    .addComponent(jLabelSpeedValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDistance)
                    .addComponent(jLabelDistanceValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelThrustForst)
                    .addComponent(jLabelThrustForstVlaue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAirForse)
                    .addComponent(jLabelAirForseValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRollingResistance)
                    .addComponent(jLabelRollingResistanceValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMinSpeed)
                    .addComponent(jLabelMaxSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonSwitcher)
                    .addComponent(jToggleButtonGas)
                    .addComponent(jToggleButtonBrake))
                .addContainerGap())
        );

        jPanelModelConfig.setBorder(javax.swing.BorderFactory.createTitledBorder("Управление моделированием"));

        jButtonStop.setText("Стоп");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonStart.setText("Старт");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jLabelTimeMult.setText("Ускорение времени:");

        spnTimeMult.setValue(1);

        jLabelTime.setText("Прошедшее время:");

        jLabelTimeValue.setText("0 сек.");

        javax.swing.GroupLayout jPanelModelConfigLayout = new javax.swing.GroupLayout(jPanelModelConfig);
        jPanelModelConfig.setLayout(jPanelModelConfigLayout);
        jPanelModelConfigLayout.setHorizontalGroup(
            jPanelModelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModelConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTimeMult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnTimeMult, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTimeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelModelConfigLayout.setVerticalGroup(
            jPanelModelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModelConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonStart)
                    .addComponent(jLabelTimeMult)
                    .addComponent(spnTimeMult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTime)
                    .addComponent(jLabelTimeValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelModelParametrs.setBorder(javax.swing.BorderFactory.createTitledBorder("Параметры модели"));

        jSpinnerPower.setValue(126);

        jSpinnerWeight.setValue(1326);

        jSpinnerAirC.setValue(0.28);

        jLabelPower.setText("Мощность (лс):");

        jLabelPower1.setText("Вес (кг):");

        jLabelPower2.setText("Коэф. Сопр. Возд.:");

        jLabelPower3.setText("Коэф. Сопр. трения:");

        javax.swing.GroupLayout jPanelModelParametrsLayout = new javax.swing.GroupLayout(jPanelModelParametrs);
        jPanelModelParametrs.setLayout(jPanelModelParametrsLayout);
        jPanelModelParametrsLayout.setHorizontalGroup(
            jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModelParametrsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModelParametrsLayout.createSequentialGroup()
                        .addComponent(jLabelPower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerPower, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModelParametrsLayout.createSequentialGroup()
                        .addComponent(jLabelPower3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerRollingC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModelParametrsLayout.createSequentialGroup()
                        .addComponent(jLabelPower1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModelParametrsLayout.createSequentialGroup()
                        .addComponent(jLabelPower2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerAirC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelModelParametrsLayout.setVerticalGroup(
            jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModelParametrsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPower1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerAirC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPower2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModelParametrsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerRollingC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPower3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonExit.setText("Выйти");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelModelConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelModelVisual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelModelParametrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelModelConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelModelVisual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelModelParametrs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        timer.start();
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        timer.stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jToggleButtonGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonGasActionPerformed
        this.jToggleButtonBrake.setSelected(false);
    }//GEN-LAST:event_jToggleButtonGasActionPerformed

    private void jToggleButtonBrakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBrakeActionPerformed
        this.jToggleButtonGas.setSelected(false);
    }//GEN-LAST:event_jToggleButtonBrakeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarModelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarModelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarModelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarModelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarModelUI().setVisible(true);
            }
        });
    }
    private double time = 0;
    private javax.swing.Timer timer;
    private Car auto;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelAirForse;
    private javax.swing.JLabel jLabelAirForseValue;
    private javax.swing.JLabel jLabelDistance;
    private javax.swing.JLabel jLabelDistanceValue;
    private javax.swing.JLabel jLabelMaxSpeed;
    private javax.swing.JLabel jLabelMinSpeed;
    private javax.swing.JLabel jLabelPower;
    private javax.swing.JLabel jLabelPower1;
    private javax.swing.JLabel jLabelPower2;
    private javax.swing.JLabel jLabelPower3;
    private javax.swing.JLabel jLabelRollingResistance;
    private javax.swing.JLabel jLabelRollingResistanceValue;
    private javax.swing.JLabel jLabelSpeed;
    private javax.swing.JLabel jLabelSpeedValue;
    private javax.swing.JLabel jLabelThrustForst;
    private javax.swing.JLabel jLabelThrustForstVlaue;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelTimeMult;
    private javax.swing.JLabel jLabelTimeValue;
    private javax.swing.JPanel jPanelModelConfig;
    private javax.swing.JPanel jPanelModelParametrs;
    private javax.swing.JPanel jPanelModelVisual;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JSpinner jSpinnerAirC;
    private javax.swing.JSpinner jSpinnerPower;
    private javax.swing.JSpinner jSpinnerRollingC;
    private javax.swing.JSpinner jSpinnerWeight;
    private javax.swing.JToggleButton jToggleButtonBrake;
    private javax.swing.JToggleButton jToggleButtonGas;
    private javax.swing.JToggleButton jToggleButtonSwitcher;
    private javax.swing.JSpinner spnTimeMult;
    // End of variables declaration//GEN-END:variables
}
