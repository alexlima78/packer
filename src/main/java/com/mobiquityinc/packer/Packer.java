package com.mobiquityinc.packer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mobiquityinc.packer.core.Extractor;
import com.mobiquityinc.packer.core.Solver;
import com.mobiquityinc.packer.domain.Sample;
import com.mobiquityinc.packer.exception.APIException;

public class Packer {

	public static String pack(String filePath) throws APIException {

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			List<String> lines = stream.collect(Collectors.toList());
			List<Sample> samples = Extractor.extractSamples(lines);
			String result = Solver.solve(samples);
			return result;

		} catch (Exception e) {
			throw new APIException(e);
		}
	
	}
	
}
