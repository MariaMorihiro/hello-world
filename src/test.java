import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.eti.mertz.wkhtmltopdf.wrapper.Pdf;
import br.eti.mertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import br.eti.mertz.wkhtmltopdf.wrapper.page.PageType;

public class test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//Pdf pdf = new Pdf();

		WrapperConfig wc = new WrapperConfig("C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf");
		Pdf pdf = new Pdf(wc);

		pdf.addPage("<html><head><meta charset=\"utf-8\"></head><h1>Müller</h1></html>", PageType.htmlAsString);
		//pdf.addPage("http://www.google.com", PageType.url);

		// Add a Table of contents
		//pdf.addToc();

		// The `wkhtmltopdf` shell command accepts different types of options such as global, page, headers and footers, and toc. Please see `wkhtmltopdf -H` for a full explanation.
		// All options are passed as array, for example:
		//pdf.addParam(new Param("--no-footer-line"), new Param("--html-header", "header.html"));
		//pdf.addParam(new Param("--enable-javascript"));

		try {
			// Save the PDF
			pdf.saveAs("C:\\pleiades_webpro8\\work20160608\\output.pdf");
			byte[] s = pdf.getPDF();
			System.out.println(s);
			InputStream InputStream = new ByteArrayInputStream(s);
			System.out.println(InputStream);

			BufferedReader br = new BufferedReader(new InputStreamReader(InputStream));

			StringBuilder sb = new StringBuilder();

			String line;

			while ((line = br.readLine()) != null) {
			   sb.append(line);
			}

			String str =sb.toString();

			br.close();

			InputStream.close();

			String encoded = new String(s,"JISAutoDetect");

			System.out.println(encoded);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
