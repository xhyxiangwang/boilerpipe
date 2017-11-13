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

import com.kohlschutter.boilerpipe.BoilerpipeExtractor;

/**
 * Provides quick access to common {@link BoilerpipeExtractor}s.
 * 提供对常见 BoilerpipeExtractor 的快速访问
 */
public final class CommonExtractors {
  private CommonExtractors() {
  }

  /**
   * Works very well for most types of Article-like HTML.
   * 对绝大多数文章式的网页效果很好
   */
  public static final ArticleExtractor ARTICLE_EXTRACTOR = ArticleExtractor.INSTANCE;

  /**
   * Usually worse than {@link ArticleExtractor}, but simpler/no heuristics.
   * 通常比ArticleExtractor差，但更简单/没有启发式
   */
  public static final DefaultExtractor DEFAULT_EXTRACTOR = DefaultExtractor.INSTANCE;

  /**
   * Like {@link DefaultExtractor}, but keeps the largest text block only.
   * 类似于 DefaultExtractor ，但只保留最大的文本块
   */
  public static final LargestContentExtractor LARGEST_CONTENT_EXTRACTOR =
          LargestContentExtractor.INSTANCE;

  /**
   * Trained on krdwrd Canola (different definition of "boilerplate"). You may give it a try.
   * 对准krdwrd Canola（和boilerplate不同的定义）
   *
   */
  public static final CanolaExtractor CANOLA_EXTRACTOR = CanolaExtractor.INSTANCE;

  /**
   * Dummy Extractor; should return the input text. Use this to double-check that your problem is
   * within a particular {@link BoilerpipeExtractor}, or somewhere else.
   * 虚拟提取器;能返回输入文字。使用这个来仔细检查你的问题是在特定的 BoilerpipeExtractor 或其他地方
   */
  public static final KeepEverythingExtractor KEEP_EVERYTHING_EXTRACTOR =
          KeepEverythingExtractor.INSTANCE;
}
