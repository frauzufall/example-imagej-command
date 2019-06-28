package com.mycompany.imagej;

import net.imagej.ImageJ;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import org.junit.Test;
import org.scijava.command.CommandModule;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GaussFilteringTest {
	@Test
	public void firstTest() throws ExecutionException, InterruptedException {

		final ImageJ ij = new ImageJ();

		// load the dataset
		RandomAccessibleInterval img = ij.op().create().img(new int[]{10,10});

		// invoke the plugin
		CommandModule result = ij.command().run(GaussFiltering.class, true, "input", img).get();

		Img output = (Img) result.getOutput("output");

		assertNotNull(output);
		assertEquals(10, output.dimension(0));
		assertEquals(10, output.dimension(1));
	}
}
