package com.jpkc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

/**
 * 
 * office文件转swf
 *
 * @param
 * @return
 * @author zhangyi
 * @date 2016年9月21日 下午1:34:38
 * @version 1.0.0
 */
public class DocConverter {

	private static Log log = LogFactory.getLog(DocConverter.class);

	/**
	 * 
	 * doc转pdf
	 * 
	 * @param sourceFile
	 * @param pdfFile
	 * @throws IOException
	 */
	public static void convertDocToPdf(File sourceFile, File pdfFile) throws IOException {
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		connection.connect();
		DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
		converter.convert(sourceFile, pdfFile);
		pdfFile.createNewFile();
		connection.disconnect();
		log.info("第二步：转换为PDF格式	路径" + pdfFile.getPath());
	}

	/**
	 * 
	 * pdf 转 swf
	 *
	 * @param
	 * @return
	 * @author zhangyi
	 * @date 2016年9月21日 下午1:34:38
	 * @version 1.0.0
	 */
	public static void convertPdfToSwf(File pdfFile, File swfFile) throws InterruptedException, IOException {
		Runtime r = Runtime.getRuntime();
		Process p;
		p = r.exec("D:/pc_tool/swftools/pdf2swf.exe " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
		// 获取进程的标准输入流
		final InputStream is1 = p.getInputStream();
		// 获取进城的错误流
		final InputStream is2 = p.getErrorStream();
		// 启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
		new Thread() {
			public void run() {
				BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
				try {
					String line1 = null;
					while ((line1 = br1.readLine()) != null) {
						if (line1 != null) {
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						is1.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
				try {
					String line2 = null;
					while ((line2 = br2.readLine()) != null) {
						if (line2 != null) {
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						is2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		p.waitFor();
		swfFile.createNewFile();
		log.info("第三步：转换为SWF格式路径：" + swfFile.getPath());
		if (pdfFile.exists()) {
			pdfFile.delete();
		}
	}

	/**
	 * 转换文件到swf
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static void convertTo(String path) throws IOException, InterruptedException {
		String suffix = path.substring(path.lastIndexOf(".") + 1); // 后缀
		File sourceFile = new File(path); // 转换的源文件
		File pdfFile = new File(path.replace(suffix, "pdf")); // PDF目标文件
		File swfFile = new File(path.replace(suffix, "swf")); // SWF目标文件

		log.info("第一步：生成文件对象，准备转换");
		// 转换成pdf文件
		if (!sourceFile.exists()) {
			log.info("要转换的文件不存在");
		}
		if (pdfFile.exists() && pdfFile.length() == 0) {
			log.info("预先存在该pdf文件且文件大小为0！");
			pdfFile.delete();
		}

		if (!pdfFile.exists()) {
			log.info("转换为pdf！");
			convertDocToPdf(sourceFile, pdfFile);
		}

		if (!pdfFile.exists()) {
			log.info("PDF文件不存在，无法转换");
			return;
		}

		if (swfFile.exists() && swfFile.length() == 0) {
			log.info("预先存在该swf文件且文件大小为0！");
			swfFile.delete();
		}

		if (!swfFile.exists()) {
			log.info("转换为swf！");
			convertPdfToSwf(pdfFile, swfFile);
		} else {
			log.info("已经转换为swf！");
		}
	}
}