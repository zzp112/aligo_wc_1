function dyniframesize(down) {
    var pTar = null;
    if (document.getElementById){
        pTar = document.getElementById(down);
    }
    else{
        eval('pTar = ' + down + ';');
    }
    if (pTar && !window.opera){
//begin resizing iframe
        pTar.style.display="block"
        if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){
//ns6 syntax
            pTar.height = pTar.contentDocument.body.offsetHeight +20;
            pTar.width = pTar.contentDocument.body.scrollWidth+20;
        }
        else if (pTar.Document && pTar.Document.body.scrollHeight){
//ie5+ syntax
            pTar.height = pTar.Document.body.scrollHeight;
            pTar.width = pTar.Document.body.scrollWidth;
        }
    }
}

function IFrameReSizeWidth(iframename) {
var pTar = document.getElementById(iframename);
if (pTar) {
if (pTar.contentDocument && pTar.contentDocument.body.offsetWidth) {
pTar.width = pTar.contentDocument.body.offsetWidth;
}
else if (pTar.Document && pTar.Document.body.scrollWidth) {
pTar.width = pTar.Document.body.scrollWidth;
}
}
}