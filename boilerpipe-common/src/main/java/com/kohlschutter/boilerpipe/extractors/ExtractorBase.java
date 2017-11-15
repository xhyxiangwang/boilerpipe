/**
 * boilerpipe
 *
 * Copyright (c) 2009, 2014 Christian Kohlschütter
 *
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kohlschutter.boilerpipe.extractors;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kohlschutter.boilerpipe.BoilerpipeExtractor;
import com.kohlschutter.boilerpipe.BoilerpipeProcessingException;
import com.kohlschutter.boilerpipe.document.TextDocument;
import com.kohlschutter.boilerpipe.sax.BoilerpipeSAXInput;
import com.kohlschutter.boilerpipe.sax.HTMLFetcher;

/**
 * The base class of Extractors. Also provides some helper methods to quickly retrieve the text that
 * remained after processing.
 */
public abstract class ExtractorBase implements BoilerpipeExtractor {

  /**
   * Extracts text from the HTML code given as a String.
   * 
   * @param html The HTML code as a String.
   * @return The extracted text.
   * @throws BoilerpipeProcessingException
   */
  public String getText(final String html) throws BoilerpipeProcessingException {
    try {
      return getText(new BoilerpipeSAXInput(new InputSource(new StringReader(html)))
          .getTextDocument());
    } catch (SAXException e) {
      throw new BoilerpipeProcessingException(e);
    }
  }

  /**
   * Extracts text from the HTML code available from the given {@link InputSource}.
   * 从给定的 InputSource 提供的HTML代码中提取文本
   * @param is The InputSource containing the HTML
   * @return The extracted text.
   * @throws BoilerpipeProcessingException
   */
  public String getText(final InputSource is) throws BoilerpipeProcessingException {
    try {
      return getText(new BoilerpipeSAXInput(is).getTextDocument());
    } catch (SAXException e) {
      throw new BoilerpipeProcessingException(e);
    }
  }

  /**
   * Extracts text from the HTML code available from the given {@link URL}. NOTE: This method is
   * mainly to be used for show case purposes. If you are going to crawl the Web, consider using
   * {@link #getText(InputSource)} instead.
   * 从给定URL中提供的HTML代码中提取文本。 注意：此方法主要用于展示用途。
   * 如果您要抓取Web，请考虑使用getText（InputSource）。
   * @param url The URL pointing to the HTML code.
   * @return The extracted text.
   * @throws BoilerpipeProcessingException
   */
  public String getText(final URL url) throws BoilerpipeProcessingException {
    try {
      return getText(HTMLFetcher.fetch(url).toInputSource());
    } catch (IOException e) {
      throw new BoilerpipeProcessingException(e);
    }
  }

  /**
   * Extracts text from the HTML code available from the given {@link Reader}.
   * 
   * @param r The Reader containing the HTML
   * @return The extracted text.
   * @throws BoilerpipeProcessingException
   */
  public String getText(final Reader r) throws BoilerpipeProcessingException {
    return getText(new InputSource(r));
  }

  /**
   * Extracts text from the given {@link TextDocument} object.
   * 
   * @param doc The {@link TextDocument}.
   * @return The extracted text.
   * @throws BoilerpipeProcessingException
   */
  public String getText(TextDocument doc) throws BoilerpipeProcessingException {
    process(doc);
    return doc.getContent();
  }
}
