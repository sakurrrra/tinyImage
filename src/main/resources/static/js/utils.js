// 文件大小单位
const sizeUnit = ['B','KB','MB','G'];

// 文件大小转换
const formatFileSize = (size) => {
    let count = 0, formatSize = size;
    while(formatSize>1024){
        formatSize = (formatSize/1024).toFixed(1);
        count++;
    }
    return formatSize + sizeUnit[count];
}