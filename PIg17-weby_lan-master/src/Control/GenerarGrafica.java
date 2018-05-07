package Control;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

import Modelo.Constantes;
import Modelo.Electro;

//Hasta aqui
public class GenerarGrafica {
	private Electro electro = null;

	public GenerarGrafica(Electro electro) throws IOException {
		this.electro = electro;

	}

	private XYDataset generarGrafica(String nombreEcg) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries(nombreEcg);
		Double[] arrayMedicion = electro.getVectorLecturas();
		Double[] arrayTiempo = electro.getVectorTiempo();
		for (int i = 0; i < arrayTiempo.length; i++) {
			double tiempo = arrayTiempo[i];
			double medicion = arrayMedicion[i];
			series1.add(tiempo, medicion);
		}

		dataset.addSeries(series1);

		return dataset;
	}

	private void customizarChart(JFreeChart grafica) {

		XYPlot plot = grafica.getXYPlot();
		ValueAxis domainAxis = plot.getDomainAxis();
		domainAxis.setRange(0.0, 5.0);// Acotamos el eje horizontal para mejor visualizacion

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.BLACK);
		Shape diamond = ShapeUtilities.createDiamond((float) 0.4);
		renderer.setSeriesShape(0, diamond);
		renderer.setSeriesShapesVisible(0, false);

		// tooltip
		renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());

		// Scroll con alt(option mac)
		plot.setDomainPannable(true);
		plot.setRangePannable(false);

		// Borde de la grafica
		plot.setOutlinePaint(Color.getHSBColor(0.0f, 1.0f, 0.55f));
		plot.setOutlineStroke(new BasicStroke(3.0f));

		// Seleccionamos el render de las líneas
		plot.setRenderer(renderer);

		// fondo de la grafica
		plot.setBackgroundPaint(Color.WHITE);

		BufferedImage image = null;
		try {
			File url = new File(Constantes.RELATIVO + File.separator + Constantes.CARPETAIMG + File.separator
					+ Constantes.FONDOGRAFICA);
			image = ImageIO.read(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		plot.setBackgroundImage(image);

		// Color líneas discontinuas del fondo

		// HORIZONTALES
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(139, 0, 0));
		// VERTICALES
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(139, 0, 0));

		plot.setDomainCrosshairPaint(Color.GREEN);
		plot.setRangeCrosshairPaint(Color.GREEN);

		// Grosor lineas de seleccion
		plot.setRangeCrosshairStroke(new BasicStroke(2.0f));
		plot.setDomainCrosshairStroke(new BasicStroke(2.0f));

		plot.setDomainCrosshairVisible(false);
		plot.setRangeCrosshairVisible(false);
	}

	public JFreeChart crearGrafica(String nombreEcg) throws IOException {
		String chartTitle = "ECG paciente";
		String xAxisLabel = "TIEMPO (Segundos)";
		String yAxisLabel = "VALORES ECG";
		XYDataset dataset = generarGrafica(nombreEcg);
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);
		customizarChart(chart);
		return chart;
	}

}
