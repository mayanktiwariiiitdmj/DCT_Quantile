package dctquant;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DCTQuantile extends javax.swing.JFrame {

    private BufferedImage inImage;
    private BufferedImage lfImage;
    private BufferedImage hfImage;
    private BufferedImage processedImage;
    private final JFileChooser fileOpen;
    private final JFileChooser imageSave;
    private File inputImageFile;
    private int imgWidth;
    private int imgHeight;
    private double inImageMatrix[][];
    private double dctMatrix[][];
    private double hfMatrix[][];
    private double lfMatrix[][];
    private final DCT dct;
    private Thread alphaThread;
    private Thread dctThread;
    private final int DCT_PATCH_SIZE = 8;
    private final int GREY_RANGE = 256;

    public DCTQuantile() {
        initComponents();

        txtImagePath.setText("this will show path of input image");
        txtImagePath.setEditable(false);
        frReset();
        dct = new DCT(DCT_PATCH_SIZE);
        lblCurrentStatus.setText("image dimentions MUST be NxN, where N=pow(2,k), for k=6,7,8,9,10");

        fileOpen = new JFileChooser();
        imageSave = new JFileChooser();
        imageSave.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        btnFixParameters.setEnabled(false);
        lblHFC.setText("");
        lblLFC.setText("");
        lblInputImage.setText("");
        lblProcessedImage.setText("");
        btnSave.setEnabled(false);

    }

    public void frReset() {
        btnSave.setEnabled(false);
        comboAlpha.setSelectedIndex(0);
        comboQuantile.setSelectedIndex(1);
        comboAlpha.setEnabled(false);
        comboQuantile.setEnabled(false);
        txtImagePath.setToolTipText("");
        txtImagePath.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtImagePath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        lblAlpha = new javax.swing.JLabel();
        lblQuantile = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        comboAlpha = new javax.swing.JComboBox<>();
        comboQuantile = new javax.swing.JComboBox<>();
        btnFixParameters = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblInputImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblHFC = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblLFC = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblProcessedImage = new javax.swing.JLabel();
        lblCurrentStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DCT Quantile 1.0 - [Grey Scale]");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Parameters ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        txtImagePath.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtImagePath.setText("txtImagePath");

        btnBrowse.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblAlpha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAlpha.setText("alpha:");

        lblQuantile.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblQuantile.setText("quantile (q):");

        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        comboAlpha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboAlpha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7" }));

        comboQuantile.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboQuantile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));

        btnFixParameters.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnFixParameters.setText("Fix Parameters");
        btnFixParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFixParametersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtImagePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlpha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuantile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboQuantile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFixParameters)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse)
                    .addComponent(comboAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlpha)
                    .addComponent(lblQuantile)
                    .addComponent(comboQuantile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave)
                    .addComponent(btnFixParameters))
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Results ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblInputImage.setText("lblInputImage");
        jScrollPane1.setViewportView(lblInputImage);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Input Image", jPanel3);

        lblHFC.setText("lblHFC");
        jScrollPane2.setViewportView(lblHFC);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("High-Frequency Component", jPanel4);

        lblLFC.setText("lblLFC");
        jScrollPane3.setViewportView(lblLFC);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Low-Frequency Component", jPanel5);

        lblProcessedImage.setText("lblProcessedImage");
        jScrollPane4.setViewportView(lblProcessedImage);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Processed Image", jPanel6);

        lblCurrentStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCurrentStatus.setText("lblCurrentStatus");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCurrentStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentStatus))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        int ret = fileOpen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            btnSave.setEnabled(false);
            comboAlpha.setSelectedIndex(0);
            comboQuantile.setSelectedIndex(0);
            comboAlpha.setEnabled(true);
            comboQuantile.setEnabled(true);

            inputImageFile = fileOpen.getSelectedFile();
            txtImagePath.setToolTipText(inputImageFile.getPath());
            txtImagePath.setText(inputImageFile.getPath());
            try {
                inImage = ImageIO.read(inputImageFile);
                imgWidth = inImage.getWidth();
                imgHeight = inImage.getHeight();

                if (imgWidth != imgHeight) {
                    JOptionPane.showMessageDialog(null, "image dimentions must be NxN, choose another image");
                    frReset();

                    return;
                } else if (imgWidth != 64 && imgWidth != 128 && imgWidth != 256 && imgWidth != 512 && imgWidth != 1024) {
                    JOptionPane.showMessageDialog(null, "image dimention is NOT pow(2,k), for k=6,7,8,9,10");
                    frReset();
                    return;
                }

                lblCurrentStatus.setText("input image size is " + imgWidth + "x" + imgHeight);
                ImageIcon imageIcon = new ImageIcon(inImage);
                btnSave.setEnabled(false);
                lblInputImage.setIcon(imageIcon);
                inImageMatrix = bitmapToMatrix(inImage);
                lblCurrentStatus.setText("input image is converted to matrix");
                dctThread = null;
                btnFixParameters.setEnabled(false);
                dctThread = new Thread(new DCTThread());
                dctThread.start();
                lblHFC.setText("");
                lblLFC.setText("");
                lblProcessedImage.setText("");
                lblHFC.setIcon(null);
                lblLFC.setIcon(null);
                lblProcessedImage.setIcon(null);
                lblInputImage.setText("");
                btnSave.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {
            frReset();
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnFixParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFixParametersActionPerformed
        // TODO add your handling code here:
        alphaThread = null;
        System.gc();
        alphaThread = new Thread(new AlphaSliderThread());
        alphaThread.start();
    }//GEN-LAST:event_btnFixParametersActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int ret = imageSave.showDialog(null, "save file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                float alpha = Float.parseFloat(comboAlpha.getSelectedItem().toString());
                int quantile = Integer.parseInt(comboQuantile.getSelectedItem().toString());
                File file = new File(imageSave.getSelectedFile() + "\\DCTQuant_al_" + alpha + "_q_" + quantile + "_" + inputImageFile.getName());
                ImageIO.write(processedImage, "png", file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "you have not chosen any location to save file");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    class DCTThread implements Runnable {

        public void run() {
            dctMatrix = new double[imgWidth][imgHeight];
            lblCurrentStatus.setText("DCT processing started");
            for (int row = 0; row < imgWidth; row += DCT_PATCH_SIZE) {
                for (int col = 0; col < imgHeight; col += DCT_PATCH_SIZE) {

                    double imgPatch[][] = new double[DCT_PATCH_SIZE][DCT_PATCH_SIZE];
                    for (int r = 0; r < DCT_PATCH_SIZE; ++r) {
                        for (int c = 0; c < DCT_PATCH_SIZE; ++c) {
                            imgPatch[r][c] = inImageMatrix[row + r][col + c];
                        }
                    }
                    double dctPatch[][] = dct.applyDCT(imgPatch);
                    for (int r = 0; r < DCT_PATCH_SIZE; ++r) {
                        for (int c = 0; c < DCT_PATCH_SIZE; ++c) {
                            dctMatrix[row + r][col + c] = dctPatch[r][c];
                        }
                    }
                }
            }
            lblCurrentStatus.setText("DCT processing finished");
            btnFixParameters.setEnabled(true);
        }
    }

    class AlphaSliderThread implements Runnable {

        public void run() {

            hfMatrix = new double[imgWidth][imgHeight];
            lfMatrix = new double[imgWidth][imgHeight];
            lblCurrentStatus.setText("LFC-HFC decomposition started");
            int threshold = (int) (Float.parseFloat(comboAlpha.getSelectedItem().toString()) * 10);
            System.out.println(threshold);

            for (int row = 0; row < imgWidth; row += DCT_PATCH_SIZE) {
                for (int col = 0; col < imgHeight; col += DCT_PATCH_SIZE) {
                    double hfPatch[][] = new double[DCT_PATCH_SIZE][DCT_PATCH_SIZE];

                    for (int r = 0; r < DCT_PATCH_SIZE; ++r) {
                        for (int c = 0; c < DCT_PATCH_SIZE; ++c) {
                            hfPatch[r][c] = dctMatrix[row + r][col + c];
                        }
                    }

                    for (int r = 0; r < DCT_PATCH_SIZE; ++r) {
                        for (int c = 0; c < DCT_PATCH_SIZE; ++c) {
                            if ((r + c) <= threshold) {
                                hfPatch[r][c] = 0.0;
                            }
                        }
                    }

                    double idctHFPatch[][] = dct.applyIDCT(hfPatch);
                    for (int r = 0; r < DCT_PATCH_SIZE; ++r) {
                        for (int c = 0; c < DCT_PATCH_SIZE; ++c) {
                            hfMatrix[row + r][col + c] = idctHFPatch[r][c];
                        }
                    }
                }
            }

            for (int row = 0; row < imgWidth; ++row) {
                for (int col = 0; col < imgHeight; ++col) {
                    lfMatrix[row][col] = (inImageMatrix[row][col] - hfMatrix[row][col]);
                    if (lfMatrix[row][col] < 0) {
                        lfMatrix[row][col] = 0;
                    } else if (lfMatrix[row][col] > 255) {
                        lfMatrix[row][col] = 255;
                    }
                }
            }

            hfImage = matrixToBufferedImage(hfMatrix);
            lfImage = matrixToBufferedImage(lfMatrix);
            lblCurrentStatus.setText("LFC-HFC decomposition finished");
            int quantle = Integer.parseInt(comboQuantile.getSelectedItem().toString());
            double processedMatrix[][] = getQuantileProcessedImage(lfMatrix, quantle);

            for (int row = 0; row < imgWidth; ++row) {
                for (int col = 0; col < imgHeight; ++col) {
                    processedMatrix[row][col] = processedMatrix[row][col] + hfMatrix[row][col];
                }
            }
            processedImage = matrixToBufferedImage(processedMatrix);
            lblProcessedImage.setIcon(new ImageIcon(processedImage));
            lblHFC.setIcon(new ImageIcon(hfImage));
            lblLFC.setIcon(new ImageIcon(lfImage));
            lblCurrentStatus.setText("finished");
            btnSave.setEnabled(true);
        }
    }

    public double[][] getQuantileProcessedImage(double mat[][], int quantile) {

        double qArr[];
        double hist[];
        double alpha[] = new double[quantile];

        hist = getHistogram(mat);
        qArr = qCalc(hist, quantile);
        qArr[quantile - 1] = GREY_RANGE - 1;

        double normHist[] = normFun(hist, 0, GREY_RANGE - 1);
        double mxProb = maxProb(normHist);
        double mnProb = minProb(normHist);
        double pbDiff = mxProb - mnProb;

        alpha[0] = alCalc(normHist, 0, (int) qArr[0]);
        for (int i = 1; i < quantile; i++) {
            alpha[i] = alCalc(normHist, (int) qArr[i - 1] + 1, (int) qArr[i]);
        }

        double pHist[] = new double[GREY_RANGE];
        powerFunct(pHist, normHist, 0, (int) qArr[0], mxProb, mnProb, pbDiff, alpha[0]);
        for (int i = 1; i < quantile; i++) {
            powerFunct(pHist, normHist, (int) qArr[i - 1] + 1, (int) qArr[i], mxProb, mnProb, pbDiff, alpha[i]);
        }
        normHist = normFun(pHist, 0, GREY_RANGE - 1);

        lblCurrentStatus.setText("applying quantile processing");

        nrmSubFun(normHist, 0, (int) qArr[0]);
        for (int i = 1; i < quantile; i++) {
            nrmSubFun(normHist, (int) qArr[i - 1] + 1, (int) qArr[i]);
        }

        he(normHist, 0, (int) qArr[0]);
        for (int i = 1; i < quantile; i++) {
            he(normHist, (int) qArr[i - 1] + 1, (int) qArr[i]);
        }
        double image[][] = getHeImg(normHist, mat);
        return image;
    }

    public void he(double hist[], int low, int high) {
        double sumr, sumrx;
        sumr = 0;
        for (int i = low; i <= high; i++) {
            sumr += (hist[i]);
            sumrx = low + (high - low) * sumr;
            if ((int) (sumrx) > (GREY_RANGE - 1)) {
                hist[i] = GREY_RANGE - 1;
            } else {
                hist[i] = (int) (sumrx);
            }
        }
    }

    public void nrmSubFun(double arr[], int low, int high) {
        double sumV = 0.0f;
        for (int i = low; i <= high; i++) {
            sumV = sumV + (arr[i]);
        }
        for (int i = low; i <= high; i++) {
            arr[i] /= sumV;
        }
    }

    public double[] normFun(double hist[], int low, int high) {
        double nHist[] = new double[high - low + 1];

        double sum = 0.0f;
        for (int i = low; i <= high; i++) {
            sum = sum + (hist[i]);
            nHist[i] = hist[i];
        }
        for (int i = low; i <= high; i++) {
            nHist[i] /= sum;
        }
        return nHist;
    }

    public void powerFunct(double dHisto[], double histo[], int low, int high, double pMax, double pMin, double pDiff, double alphaV) {
        for (int i = low; i <= high; i++) {
            double numOne, denOne, result;
            numOne = (histo[i]) - pMin;
            denOne = (pMax - pMin);
            result = (double) Math.pow((numOne / denOne), alphaV);
            result = (pMax * result);
            dHisto[i] = result;
        }
    }

    public double[][] getHeImg(double normHist[], double matrix[][]) {

        double image[][] = new double[imgWidth][imgHeight];
        for (int row = 0; row < imgWidth; ++row) {
            for (int col = 0; col < imgHeight; ++col) {
                double pixel = normHist[(int) matrix[row][col]];
                image[row][col] = pixel;
            }
        }
        return image;
    }

    public double[] getHistogram(double mat[][]) {
        double[] hist = new double[GREY_RANGE];

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                ++hist[(int) mat[i][j]];
            }
        }
        return hist;
    }

    public double[] qCalc(double hist[], int q) {
        double qArr[] = new double[q];
        double tPx = imgWidth * imgHeight;
        for (int i = 1; i < q; i++) {
            double sum = 0.0f;
            for (int r = 0; r < hist.length; r++) {
                sum += (hist[r] / tPx);
                if (sum >= (((double) i) / (q))) {
                    qArr[i - 1] = r;
                    break;
                }
            }
        }
        return qArr;
    }

    public double maxProb(double nH[]) {
        double max;
        double m = nH[0];
        for (int i = 0; i < nH.length; i++) {
            if (m < nH[i]) {
                m = nH[i];
            }
        }
        max = m;
        return max;
    }

    public double minProb(double nH[]) {
        double min;
        double m = nH[0];
        for (int i = 0; i < nH.length; i++) {
            if (m > nH[i]) {
                m = nH[i];
            }
        }
        min = m;
        return min;
    }

    public double alCalc(double arr[], int l, int h) {
        double sum = 0.0f;
        for (int i = l; i <= h; i++) {
            sum = sum + (arr[i]);
        }
        return sum;
    }

    public BufferedImage matrixToBufferedImage(double matrix[][]) {

        BufferedImage image = new BufferedImage(imgWidth, imgHeight, inImage.getType());

        for (int row = 0; row < imgWidth; ++row) {
            for (int col = 0; col < imgHeight; ++col) {
                int red = (int) Math.round(matrix[row][col]);
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                }
                int alpha = new Color(inImage.getRGB(row, col)).getAlpha();
                int color = colorToRGB(alpha, red, red, red);
                image.setRGB(row, col, color);
            }
        }
        return image;
    }

    public int colorToRGB(int alpha, int red, int green, int blue) {
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;
        return newPixel;
    }

    public double[][] bitmapToMatrix(BufferedImage image) {

        double mat[][] = new double[imgWidth][imgHeight];

        for (int row = 0; row < imgWidth; ++row) {
            for (int col = 0; col < imgHeight; ++col) {
                int pixel = image.getRGB(row, col);
                mat[row][col] = (new Color(pixel).getRed()) * 1.0;
            }
        }
        return mat;
    }

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
            java.util.logging.Logger.getLogger(DCTQuantile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCTQuantile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCTQuantile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCTQuantile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCTQuantile().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnFixParameters;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboAlpha;
    private javax.swing.JComboBox<String> comboQuantile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAlpha;
    private javax.swing.JLabel lblCurrentStatus;
    private javax.swing.JLabel lblHFC;
    private javax.swing.JLabel lblInputImage;
    private javax.swing.JLabel lblLFC;
    private javax.swing.JLabel lblProcessedImage;
    private javax.swing.JLabel lblQuantile;
    private javax.swing.JTextField txtImagePath;
    // End of variables declaration//GEN-END:variables
}

class DCT {

    private int n;
    private double c[];

    public DCT(int n) {
        this.n = n;
        c = new double[n];
        this.initializeCoefficients();
    }

    private void initializeCoefficients() {
        for (int i = 1; i < n; i++) {
            c[i] = 1;
        }
        c[0] = (double) (1.0f / Math.sqrt(2.0f));
    }

    public double[][] applyDCT(double[][] f) {
        double[][] F = new double[n][n];
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                double sum = 0.0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sum += Math.cos(((2 * i + 1) / (2.0 * n)) * u * Math.PI) * Math.cos(((2 * j + 1) / (2.0 * n)) * v * Math.PI) * f[i][j];
                    }
                }
                sum *= ((c[u] * c[v]) / 4.0);
                F[u][v] = sum;
            }
        }
        return F;
    }

    public double[][] applyIDCT(double[][] F) {
        double[][] f = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0.0;
                for (int u = 0; u < n; u++) {
                    for (int v = 0; v < n; v++) {
                        sum += ((c[u] * c[v]) / 4.0) * Math.cos(((2 * i + 1) / (2.0 * n)) * u * Math.PI) * Math.cos(((2 * j + 1) / (2.0 * n)) * v * Math.PI) * F[u][v];
                    }
                }
                f[i][j] = Math.round(sum);
            }
        }
        return f;
    }
}
