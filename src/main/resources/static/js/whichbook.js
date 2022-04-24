let mapContainer = document.getElementById('map'); //지도르 표시할 div
let curPos = new kakao.maps.LatLng(curLat, curLng);

let mapOptions = {
    center: curPos,   //지도의 중심좌표
    level: 4 // 지도의 확대 레벨
};
//지도 생성
let map = new kakao.maps.Map(mapContainer, mapOptions);

/* 마커 등록 및 지도 이동*/

// 매장 포인트들
let points = [];
list.forEach(function (dto) {
    let lat = dto.latitude;
    let lng = dto.longitude;
    let pos = new kakao.maps.LatLng(lat, lng);
    points.push(pos);
})
if (list.length > 0) {
    let bounds = new kakao.maps.LatLngBounds();

    let i, marker;
    for (i = 0; i < points.length; i++) {
        // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
        marker = new kakao.maps.Marker({position: points[i]});
        marker.setMap(map);

        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(points[i]);
    }
    map.setBounds(bounds);
}

$(".list-group-item").on("click", function (event) {
    event.preventDefault();
    let pos = this.href;
    let lat = pos.slice(pos.lastIndexOf('/') + 1, pos.lastIndexOf(','));
    let lng = pos.slice(pos.lastIndexOf(",") + 1);
    panTo(lat, lng);
})

function panTo(lat, lng) {
    // 이동할 위도 경도 위치를 생성합니다
    var moveLatLon = new kakao.maps.LatLng(lat, lng);

    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.setCenter(moveLatLon);
}