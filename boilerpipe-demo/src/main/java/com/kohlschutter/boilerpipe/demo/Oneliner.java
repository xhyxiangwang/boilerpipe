/**
 * boilerpipe
 * <p>
 * Copyright (c) 2009, 2014 Christian Kohlsch??tter
 * <p>
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kohlschutter.boilerpipe.demo;

import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

import com.kohlschutter.boilerpipe.extractors.ArticleExtractor;
import com.kohlschutter.boilerpipe.extractors.CommonExtractors;
import com.kohlschutter.boilerpipe.extractors.DefaultExtractor;

/**
 * Demonstrates how to use Boilerpipe to get the main content as plain text. Note: In real-world
 * cases, you'd probably want to download the file first using a fault-tolerant crawler.
 * 在现实情况下，你可能希望优先使用容错爬虫来下载文件
 *
 * @see HTMLHighlightDemo if you need HTML as well.
 */
public class Oneliner {
    public static void main(final String[] args) throws Exception {
        final URL url =
                new URL(
//                        "http://news.sina.com.cn/c/nd/2017-11-13/doc-ifynstfh6707455.shtml"
//                        "https://weibo.com/p/1005051802675712/home?from=page_100505_profile&wvr=6&mod=data&is_hot=1#place"

//                        "http://www.sina.com.cn/"
                        "http://www.ftchinese.com/story/001075033#adchannelID=1300"

//                        "http://news.fengsung.com/n-171030162000354.html"

//                        "http://blog.openshift.com/day-18-boilerpipe-article-extraction-for-java-developers/"

//                        "http://www.dn.se/nyheter/vetenskap/annu-godare-choklad-med-hjalp-av-dna-teknik"
                );

        String fileContent = ArticleExtractor.INSTANCE.getText(url);

//        String encode = URLEncoder.encode(fileContent, "");
        WriteFile.writeFile("/Users/xianghongyan/AndroidStudioProjects/boilerpipe/out/filecontent.txt", fileContent);

        System.out.println(url);
        System.out.println("*" + ArticleExtractor.INSTANCE.getText(url));


        // Also try other extractors!
//         System.out.println("D"+DefaultExtractor.INSTANCE.getText(url));
//         System.out.println("C"+CommonExtractors.CANOLA_EXTRACTOR.getText(url));
    }
}
