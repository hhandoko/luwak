/**
 * File     : webpack.config.js
 * License  :
 *   Copyright (c) 2017 Herdy Handoko
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
var path = require('path');
var webpack = require('webpack');
var CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    devtool: 'eval',
    entry: path.resolve(__dirname, 'src/main/react/index'),
    output: {
        path: path.resolve(__dirname, 'src/main/resources/app'),
        filename: 'app.js',
        publicPath: '/'
    },
    module: {
        rules: [{
            test: /\.jsx?$/,
            exclude: /node_modules/,
            use: [
                { loader: 'babel-loader' }
            ]
        }, {
            test: /\.scss?$/,
            use: [
                { loader: 'style-loader' },
                { loader: 'css-loader' },
                { loader: 'sass-loader' }
            ]
        }]

    },
    devServer: {
        contentBase: path.join(__dirname, 'src/main/resources/app'),
        compress: true,
        port: 3000
    },
    plugins: [
        new webpack.NamedModulesPlugin(),
        new CopyWebpackPlugin([{
            from: path.resolve(__dirname, 'src/main/react/index.html'),
            to: 'index.html'
        }])
    ]
};
